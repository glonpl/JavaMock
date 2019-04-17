import Controllers.KlientController;
import Interfaces.IKlient;
import Interfaces.IZamowienie;
import Models.Klient;
import Validations.IValidation;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.expect;
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
}
