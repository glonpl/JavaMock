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
    void addClientNullThrowsException() {
        expect(validator.klientNull(null)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.addKlient(null), "klient is null");
    }

    @Test
    void addClientInvalidReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.klientNull(klient)).andReturn(false);
        expect(validator.klientValid(klient)).andReturn(false);
        replay(validator);
        assertFalse(klientController.addKlient(klient));
    }

    @Test
    void addClientProperlyReturnsTrue() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.klientNull(klient)).andReturn(false);
        expect(validator.klientValid(klient)).andReturn(true);
        replay(validator);
        expect(klientRepository.addKlient(klient)).andReturn(true);
        replay(klientRepository);
        assertSame(true, klientController.addKlient(klient));
    }
    //deleting

    @Test
    void deleteNullClientThrowsException() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.klientNull(klient)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.deleteKlient(klient), "Klient is null");
    }

    @Test
    void deleteNonExistingClientReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        expect(validator.klientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.getKlient(klient.getId())).andReturn(null);//could actually comment this two lines
        replay(klientRepository);
        assertFalse(klientController.deleteKlient(klient));
    }

    @Test
    void deleteClientWithOrdersReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");
        Zamowienie zamowienie = new Zamowienie(1, klient);
        List<Zamowienie> zamowienia = new ArrayList<>();
        zamowienia.add(zamowienie);

        expect(validator.klientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.getKlient(1)).andReturn(klient);
        expect(klientRepository.deleteKlient(klient)).andReturn(true);
        replay(klientRepository);
        expect(zamowienieRepository.getZamowienieFromKlient(klient)).andReturn(zamowienia);
        replay(zamowienieRepository);
        assertFalse(klientController.deleteKlient(klient));
    }

    @Test
    void deleteClientProperlyReturnsNotFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.klientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.getKlient(1)).andReturn(klient);
        expect(klientRepository.deleteKlient(klient)).andReturn(true);
        replay(klientRepository);
        expect(zamowienieRepository.getZamowienieFromKlient(klient)).andReturn(new ArrayList<>());
        replay(zamowienieRepository);
        assertThat(klientController.deleteKlient(klient)).isNotEqualTo(false);
    }

    //update
    @Test
    void updateNullClientThrowsException() {
        expect(validator.klientNull(null)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.updateKlient(null), "Klient is null");
    }

    @Test
    void updateInvalidClientReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.klientNull(klient)).andReturn(false);
        expect(validator.klientValid(klient)).andReturn(false);
        replay(validator);
        assertFalse(klientController.updateKlient(klient));
    }

    @Test
    void updateUnExistingClientReturnsFalse() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.klientNull(klient)).andReturn(false);
        expect(validator.klientValid(klient)).andReturn(true);
        replay(validator);
        expect(klientRepository.getKlient(klient.getId())).andReturn(null);//could actually comment this two lines
        replay(klientRepository);

        assertFalse(klientController.updateKlient(klient));
    }

    @Test
    void updateClientReturnsTrue() {
        Klient klient = new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl");

        expect(validator.klientNull(klient)).andReturn(false);
        expect(validator.klientValid(klient)).andReturn(true);
        replay(validator);
        expect(klientRepository.getKlient(klient.getId())).andReturn(klient);
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
    void getKlientreturnsKlientType() {
        expect(klientRepository.getKlient(1)).andReturn(new Klient(1, "Adam", "Jodłowski", "ajodl@o2.pl"));
        replay(klientRepository);

        assertThat(klientRepository.getKlient(1)).isInstanceOf(Klient.class);
    }
}
