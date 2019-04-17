import Controllers.KlientController;
import Interfaces.IKlient;
import Interfaces.IZamowienie;
import Models.Klient;
import Models.Zamowienie;
import Validations.IValidation;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

public class KlientControllerEMTest {
    private IKlient klientRepository;
    private IValidation validator;
    private IZamowienie zamowienieRepository;
    private KlientController klientController;

    @BeforeEach
    void setUp(){

        klientRepository = EasyMock.createMock(IKlient.class);
        validator = EasyMock.createMock(IValidation.class);
        zamowienieRepository = EasyMock.createMock(IZamowienie.class);
        klientController = new KlientController(klientRepository,validator, zamowienieRepository);
    }
    //adding
    @Test
    void AddClientNullThrowsException(){
        Klient klient = new Klient(1,"Adam","Jodłowski","ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.AddKlient(klient), "klient is null");
    }
    @Test
    void AddClientInvalidReturnsFalse(){
        Klient klient = new Klient(1,"Adam","Jodłowski","ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(false);
        expect(validator.KlientValid(klient)).andReturn(false);
        replay(validator);
        assertFalse(klientController.AddKlient(klient));
    }
    @Test
    void AddClientProperlyReturnsTrue(){
        Klient klient = new Klient(1,"Adam","Jodłowski","ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(false);
        expect(validator.KlientValid(klient)).andReturn(true);
        replay(validator);
        expect(klientRepository.AddKlient(klient)).andReturn(true);
        replay(klientRepository);
        assertSame(true,klientController.AddKlient(klient));
    }
    //deleting

    @Test
    void DeleteNullClientThrowsException(){
        Klient klient = new Klient(1,"Adam","Jodłowski","ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(true);
        replay(validator);
        assertThrows(IllegalArgumentException.class, () -> klientController.DeleteKlient(klient), "Klient is null");
    }
    @Test
    void DeleteNonExistingClientReturnsFalse(){
        Klient klient = new Klient(1,"Adam","Jodłowski","ajodl@o2.pl");
        expect(validator.KlientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.GetKlient(klient.getId())).andReturn(null);//could actually comment this two lines
        replay(klientRepository);
        assertFalse(klientController.DeleteKlient(klient));
    }
    @Test
    void DeleteClientWithOrdersReturnsFalse(){
               Klient klient = new Klient(1,"Adam","Jodłowski","ajodl@o2.pl");
        Zamowienie zamowienie = new Zamowienie(1,klient);
        List<Zamowienie> zamowienia = new ArrayList<>();
        zamowienia.add(zamowienie);

        expect(validator.KlientNull(klient)).andReturn(false);
        replay(validator);
        expect(klientRepository.GetKlient(1)).andReturn(klient);
        expect(klientRepository.DeleteKlient(klient)).andReturn(true);
        replay(klientRepository);
        expect(zamowienieRepository.GetZamowienieFromKlient(1)).andReturn(zamowienia);
        replay(zamowienieRepository);
        assertFalse(klientController.DeleteKlient(klient));
    }


   // klientRepository.GetKlient(klient.getId()) == null
}
