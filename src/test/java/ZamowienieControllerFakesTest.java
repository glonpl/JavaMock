import Controllers.PrzedmiotController;
import Fakes.PrzedmiotMock;
import Fakes.Zamowienie_PrzedmiotMock;
import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie_Przedmiot;
import Models.Przedmiot;
import Models.Zamowienie;
import Models.Zamowienie_Przedmiot;
import Validations.IValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ZamowienieControllerFakesTest {

    private IPrzedmiot przedmiotRepository;
    private IValidation validator;
    private PrzedmiotController przedmiotController;

    @BeforeEach
    void setUp(){
        przedmiotRepository = new PrzedmiotMock();
    }
    @Test
    void NullPrzedmiotThrowsException(){
        IZamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_PrzedmiotMock() {

        }
    }
}
