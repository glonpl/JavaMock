import controllers.KlientController;
import interfaces.IKlient;
import interfaces.IZamowienie;
import models.Klient;
import models.Zamowienie;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validations.IValidation;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

public class KlientControllerEMTest {
    private IKlient klientRepository;
    private IValidation validator;
    private IZamowienie zamowienieRepository;
    private KlientController klientController;

    @BeforeEach
    void setUp() {

        klientRepository = EasyMock.createMock(IKlient.class);
        validator = EasyMock.createMock(IValidation.class);
        zamowienieRepository = EasyMock.createMock(IZamowienie.class);
        klientController = new KlientController(klientRepository, validator, zamowienieRepository);
    }

    //adding
    @Test
    void AddClientNullThrowsException() {
        expect(validator.KlientNull(null)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.AddKlient(null), "klient is null");
    }

    @Test
    void AddClientInvalidReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(false);
        expect(validator.KlientValid(klient)).andReturn(false);
        replay(validator);
        assertFalse(klientController.AddKlient(klient));
    }

    @Test
    void AddClientProperlyReturnsTrue() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(false);
        expect(validator.KlientValid(klient)).andReturn(true);
        replay(validator);
        expect(klientRepository.AddKlient(klient)).andReturn(true);
        replay(klientRepository);
        assertSame(true, klientController.AddKlient(klient));
    }
    //deleting

    @Test
    void DeleteNullClientThrowsException() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.DeleteKlient(klient), "Klient is null");
    }

    @Test
    void DeleteNonExistingClientReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.GetKlient(klient.getId())).andReturn(null);//could actually comment this two lines
        replay(klientRepository);
        assertFalse(klientController.DeleteKlient(klient));
    }

    @Test
    void DeleteClientWithOrdersReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        Zamowienie zamowienie = new Zamowienie(1, klient);
        List<Zamowienie> zamowienia = new ArrayList<>();
        zamowienia.add(zamowienie);

        expect(validator.KlientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.GetKlient(1)).andReturn(klient);
        expect(klientRepository.DeleteKlient(klient)).andReturn(true);
        replay(klientRepository);
        expect(zamowienieRepository.GetZamowienieFromKlient(klient)).andReturn(zamowienia);
        replay(zamowienieRepository);
        assertFalse(klientController.DeleteKlient(klient));
    }

    @Test
    void DeleteClientProperlyReturnsNotFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.KlientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.GetKlient(1)).andReturn(klient);
        expect(klientRepository.DeleteKlient(klient)).andReturn(true);
        replay(klientRepository);
        expect(zamowienieRepository.GetZamowienieFromKlient(klient)).andReturn(new ArrayList<>());
        replay(zamowienieRepository);
        assertThat(klientController.DeleteKlient(klient)).isNotEqualTo(false);
    }

    //update
    @Test
    void updateNullClientThrowsException() {
        expect(validator.KlientNull(null)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.updateKlient(null), "Klient is null");
    }

    @Test
    void updateInvalidClientReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.KlientNull(klient)).andReturn(false);
        expect(validator.KlientValid(klient)).andReturn(false);
        replay(validator);
        assertFalse(klientController.updateKlient(klient));
    }

    @Test
    void updateUnExistingClientReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.KlientNull(klient)).andReturn(false);
        expect(validator.KlientValid(klient)).andReturn(true);
        replay(validator);
        expect(klientRepository.GetKlient(klient.getId())).andReturn(null);//could actually comment this two lines
        replay(klientRepository);

        assertFalse(klientController.updateKlient(klient));
    }

    @Test
    void updateClientReturnsTrue() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.KlientNull(klient)).andReturn(false);
        expect(validator.KlientValid(klient)).andReturn(true);
        replay(validator);
        expect(klientRepository.GetKlient(klient.getId())).andReturn(klient);
        expect(klientRepository.updateKlient(klient)).andReturn(true);
        replay(klientRepository);
        assertTrue(klientController.updateKlient(klient));
    }

    //getters
    @Test
    void getAllReturnsList() {
        List<Klient> klients = new ArrayList<>();
        Klient klient1 = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        Klient klient2 = new Klient(2, "Zbychu", "Wodecki", "zwodecki@o2.pl");
        klients.add(klient1);
        klients.add(klient2);
        expect(klientRepository.getAll()).andReturn(klients);
        replay(klientRepository);
        assertEquals(true, klientRepository.getAll().contains(klient2));
    }

    @Test
    void getAllReturnsEmptyListWhenNoKlient() {
        expect(klientRepository.getAll()).andReturn(new ArrayList<>());
        replay(klientRepository);

        assertEquals(0, klientRepository.getAll().size());
    }

    @Test
    void GetKlientreturnsKlientType() {
        expect(klientRepository.GetKlient(1)).andReturn(new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl"));
        replay(klientRepository);

        assertThat(klientRepository.GetKlient(1)).isInstanceOf(Klient.class);
    }
}
