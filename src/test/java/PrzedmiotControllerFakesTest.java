import Controllers.PrzedmiotController;
import Fakes.*;
import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie_Przedmiot;
import Models.Przedmiot;
import Validations.IValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrzedmiotControllerFakesTest {

    private IPrzedmiot przedmiotRepository;
    private IValidation validator;
    private IZamowienie_Przedmiot zamowienie_przedmiot;
    private PrzedmiotController przedmiotController;

    @BeforeEach
    void setUp(){
        przedmiotRepository = new PrzedmiotMock();
    }
    @Test
    void AddPrzedmiotNullPrzedmiotThrowsException(){
        zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        validator = new AllFalseValEmptyValidatorMock();
      PrzedmiotController  przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThrows(IllegalArgumentException.class, () -> przedmiotController.AddPrzedmiot(null));

    }
    @Test
    void AddPrzedmiotInvalidPrzedmiotIsFalse(){
       zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        validator = new AllFalseValEmptyPrzedmiotNotNullValidatorMock();
        przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.AddPrzedmiot(new Przedmiot(1,"elo",23.33))).isFalse();

    }
    @Test
    void AddPrzedmiotValidPrzedmiotReturnsTrue(){
      zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
       validator = new AllFineValidMock();
        przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.AddPrzedmiot(new Przedmiot(1,"elo",23.33))).isTrue();

    }
    @Test
    void DeletePrzedmiotNullPrzedmiotThrowsException(){
         zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
         validator = new AllFalseValEmptyValidatorMock();
         przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThatThrownBy(()->przedmiotController.DeletePrzedmiot(null)).hasMessage("przedmiot is null");

    }
    @Test
    void DeletePrzedmiotNotNullInvalidPrzedmiotReturnsFalse(){
         zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
         validator = new AllFalseValEmptyPrzedmiotNotNullValidatorMock();
         przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.DeletePrzedmiot(new  Przedmiot(1,"elo",23.33))).isFalse();

    }
    @Test
    void DeletePrzedmiotGetIdEqualsNullReturnsFalse(){
         zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
         validator = new AllFineValidMock();
        przedmiotRepository = new PrzedmiotGetErrMock();
         przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.DeletePrzedmiot(new  Przedmiot(1,"elo",23.33))).isFalse();

    }
    @Test
    void DeletePrzedmiotGetAllByPrzedmiotIsEmptyReturnsFalse(){
        zamowienie_przedmiot = new ZamowieniePrzedmiotNullPrzedmiotMock();
        validator = new AllFineValidMock();
         przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.DeletePrzedmiot(new  Przedmiot(1,"elo",23.33))).isIn(false);

    }
    @Test
    void DeletePrzedmiotAllFineReturnsTrue(){
        zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        validator = new AllFineValidMock();

        przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);
        Przedmiot przedmiot=new  Przedmiot(1,"elo",23.33);
przedmiotController.AddPrzedmiot(przedmiot);
        assertThat(przedmiotController.DeletePrzedmiot(przedmiot)).isIn(true);

    }

    @Test
    void UpdatePrzedmiotNullPrzedmiotThrowsException(){
        zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        validator = new AllFalseValEmptyValidatorMock();
        PrzedmiotController  przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThrows(IllegalArgumentException.class, () -> przedmiotController.UpdatePrzedmiot(null));

    }
    @Test
    void UpdatePrzedmiotNotNullInvalidPrzedmiotReturnsFalse(){
        zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        validator = new AllFalseValEmptyPrzedmiotNotNullValidatorMock();
        przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.UpdatePrzedmiot(new  Przedmiot(1,"elo",23.33))).isFalse();

    }
    @Test
    void UpdatePrzedmiotInvalidPrzedmiotIsFalse(){
        zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        validator = new AllFalseValEmptyPrzedmiotNotNullValidatorMock();
        przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.UpdatePrzedmiot(new Przedmiot(1,"elo",23.33))).isFalse();

    }

    @Test
    void UpdatePrzedmiotValidPrzedmiotReturnsTrue(){
        zamowienie_przedmiot = new Zamowienie_PrzedmiotMock();
        validator = new AllFineValidMock();
        przedmiotController = new PrzedmiotController(validator,przedmiotRepository,zamowienie_przedmiot);

        assertThat(przedmiotController.AddPrzedmiot(new Przedmiot(1,"elo",23.33))).isTrue();

    }



}
