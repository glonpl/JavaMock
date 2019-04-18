import Controllers.PrzedmiotController;
import Fakes.AllFalseValEmptyPrzedmiotNotNullValidatorMock;
import Fakes.AllFalseValEmptyValidatorMock;
import Fakes.*;
import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie_Przedmiot;
import Models.Przedmiot;
import Models.Zamowienie;
import Models.Zamowienie_Przedmiot;
import Validations.IValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZamowienieControllerFakesTest {

    private IPrzedmiot przedmiotRepository;
    private IValidation validator;
    private PrzedmiotController przedmiotController;

    @BeforeEach
    void setUp(){
        przedmiotRepository = new PrzedmiotMock();
    }
    @Test
    void AddPrzedmiotNullPrzedmiotThrowsException(){
        IZamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        IValidation validator = new AllFalseValEmptyValidatorMock();
      PrzedmiotController  przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThrows(IllegalArgumentException.class, () -> przedmiotController.AddPrzedmiot(null));

    }
    @Test
    void AddPrzedmiotInvalidPrzedmiotIsFalse(){
        IZamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        IValidation validator = new AllFalseValEmptyPrzedmiotNotNullValidatorMock();
        PrzedmiotController  przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.AddPrzedmiot(new Przedmiot(1,"elo",23.33))).isFalse();

    }
    @Test
    void AddPrzedmiotValidPrzedmiotReturnsTrue(){
        IZamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        IValidation validator = new AllFineValidMock();
        PrzedmiotController  przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.AddPrzedmiot(new Przedmiot(1,"elo",23.33))).isTrue();

    }
}
