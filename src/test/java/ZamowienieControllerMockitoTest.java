import controllers.ZamowienieController;
import interfaces.IPrzedmiot;
import interfaces.IZamowienie;
import interfaces.IZamowienie_Przedmiot;
import models.Klient;
import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import validations.IValidation;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ZamowienieControllerMockitoTest {
    private IZamowienie zamowienieRepository;
    private IZamowienie_Przedmiot zamowienie_przedmiotRepository;
    private IPrzedmiot przedmiotRepository;
    private IValidation validator;
    private ZamowienieController zamowienieController;

    @BeforeEach
    void setup() {
        zamowienieRepository = Mockito.mock(IZamowienie.class);
        zamowienie_przedmiotRepository = Mockito.mock(IZamowienie_Przedmiot.class);
        przedmiotRepository = Mockito.mock(IPrzedmiot.class);
        validator = Mockito.mock(IValidation.class);
        zamowienieController = new ZamowienieController(zamowienieRepository, zamowienie_przedmiotRepository, przedmiotRepository, validator);
    }

    //crud
    @Test
    void addzamowienieNullThrowsException() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.addZamowienie(zamowienie), "Zamowienie is null");
    }

    @Test
    void addZamowienieProperReturnsTrue() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.addZamowienie(zamowienie)).thenReturn(true);
        assertThat(zamowienieController.addZamowienie(zamowienie)).isTrue();
    }

    @Test
    void updatezamowienieNullThrowsException() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.updateZamowienie(zamowienie), "Zamowienie is null");
    }

    @Test
    void updateZamowienieProperReturnsTrue() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.updateZamowienie(zamowienie)).thenReturn(true);
        assertThat(zamowienieController.updateZamowienie(zamowienie)).isTrue();
    }

    @Test
    void updateZamowienieInProperReturnsFalse() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.updateZamowienie(zamowienie)).thenReturn(false);
        assertThat(zamowienieController.updateZamowienie(zamowienie)).isNotEqualTo(true);
    }

    @Test
    void deletezamowienieNullThrowsException() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.deleteZamowienie(zamowienie), "Zamowienie is null");
    }

    @Test
    void deleteZamowienieProperReturnsTrue() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.deleteZamowienie(zamowienie)).thenReturn(true);
        assertThat(zamowienieController.deleteZamowienie(zamowienie)).isTrue();
    }

    @Test
    void deleteZamowienieInProperReturnsFalse() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        when(validator.zamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.deleteZamowienie(zamowienie)).thenReturn(false);
        assertThat(zamowienieController.deleteZamowienie(zamowienie)).isIn(false, 1);
    }

    //add/delete przedmiot
    @Test
    void addPrzedmiotToZamowieniezamowienieNullThrowsException() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.43);
        when(validator.zamowienieNull(zamowienie)).thenReturn(true);
        when(validator.przedmiotNull(przedmiot)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.addPrzedmiotToZamowienie(przedmiot, zamowienie), "Zamowienie or Przedmiot  is null");
    }

    @Test
    void addPrzedmiotTozamowienieNullPrzedmiotPrzedmiotThrowsException() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.43);
        when(validator.zamowienieNull(zamowienie)).thenReturn(false);
        when(validator.przedmiotNull(przedmiot)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.addPrzedmiotToZamowienie(przedmiot, zamowienie), "Zamowienie or Przedmiot  is null");
    }

    @Test
    void addPrzedmiotToZamowienieAndprzedmiotNullPrzedmiotThrowsException() {
        Zamowienie zamowienie = new Zamowienie(1, new Klient(1, "Zbigniew", "Wodecki", "zwodecki@wp.pl"));
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.43);
        when(validator.zamowienieNull(zamowienie)).thenReturn(true);
        when(validator.przedmiotNull(przedmiot)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.addPrzedmiotToZamowienie(przedmiot, zamowienie), "Zamowienie or Przedmiot  is null");
    }


    @Test
    void addPrzedmiotToZamowienieReturnsFalseWhenPrzedmiotIsInZamowienie_przedmiot() {
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0, new Klient(1, "adam", "Malysz", "amalysz@wp.pl"));
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();

        zamowienie_przedmiots.add(new Zamowienie_Przedmiot(1, 1));

        when(zamowienie_przedmiotRepository.getAllByPrzedmiot(przedmiot)).thenReturn(zamowienie_przedmiots);

        assertFalse(zamowienieController.addPrzedmiotToZamowienie(przedmiot, zamowienie));
    }

    @Test
    void addPrzedmiotToZamowienieReturnsTrueWhenPrzedmiotIsNotInZamowienie_przedmiot() {
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0, new Klient(1, "adam", "Malysz", "amalysz@wp.pl"));
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();


        when(zamowienie_przedmiotRepository.getAllByPrzedmiot(any(Przedmiot.class))).thenReturn(zamowienie_przedmiots);
        when(zamowienie_przedmiotRepository.addZamowieniePrzedmiot(any(Zamowienie_Przedmiot.class))).thenReturn(true);

        assertTrue(zamowienieController.addPrzedmiotToZamowienie(przedmiot, zamowienie));
    }

    @Test
    void deletePrzedmiotFromZamowienieThrowsExceptionWhenBothAreNull() {
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0, new Klient(1, "adam", "Malysz", "amalysz@wp.pl"));
        when(validator.przedmiotNull(przedmiot)).thenReturn(true);
        when(validator.zamowienieNull(zamowienie)).thenReturn(true);

        when(zamowienie_przedmiotRepository.addZamowieniePrzedmiot(any(Zamowienie_Przedmiot.class))).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.deletePrzedmiotFromZamowienie(przedmiot, zamowienie));
    }

    @Test
    void deletePrzedmiotFromZamowienieThrowsExceprionWhenZamowienieIsNull() {
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0, new Klient(1, "adam", "Malysz", "amalysz@wp.pl"));
        when(validator.przedmiotNull(przedmiot)).thenReturn(true);
        when(validator.zamowienieNull(zamowienie)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> zamowienieController.deletePrzedmiotFromZamowienie(przedmiot, zamowienie));
    }

    @Test
    void deletePrzedmiotFromZamowienieReturnsFalseWhenPrzedmiotIsNotInzamowienieprzedmiot() {
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0, new Klient(1, "adam", "Malysz", "amalysz@wp.pl"));
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();


        when(zamowienie_przedmiotRepository.getAllByPrzedmiot(any(Przedmiot.class))).thenReturn(zamowienie_przedmiots);

        assertThat(zamowienieController.deletePrzedmiotFromZamowienie(przedmiot, zamowienie)).isIn(false);
    }

    @Test
    void deletePrzedmiotFromZamowienieReturnsTrueWhenPrzedmiotIsInzamowienieprzedmiot() {
        Przedmiot przedmiot = new Przedmiot(1, "Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0, new Klient(1, "adam", "Malysz", "amalysz@wp.pl"));
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();
        zamowienie_przedmiots.add(new Zamowienie_Przedmiot(1, 1));


        when(zamowienie_przedmiotRepository.getAllByPrzedmiot(any(Przedmiot.class))).thenReturn(zamowienie_przedmiots);
        when(zamowienie_przedmiotRepository.getAllByZamowienie(any(Zamowienie.class))).thenReturn(zamowienie_przedmiots);
        when(zamowienie_przedmiotRepository.deleteZamowieniePrzedmiot(any(Zamowienie_Przedmiot.class))).thenReturn(true);

        assertTrue(zamowienieController.deletePrzedmiotFromZamowienie(przedmiot, zamowienie));
    }

    //getAll

    @Test
    void getAllByClientsShouldThrowWhenClientIsNull() {
        Klient klient = new Klient(1, "adam", "małysz", "elo@cos.pl");
        when(validator.klientNull(klient)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> zamowienieController.allZamowienieByKlient(klient));
    }

    @Test
    void getAllByClientsReturnsEmptyListWhenListIsEmpty() {
        Klient klient = new Klient(1, "adam", "małysz", "elo@cos.pl");
        List<Zamowienie> zamowienies = new ArrayList<>();
        when(zamowienieRepository.getZamowienieFromKlient(any(Klient.class))).thenReturn(zamowienies);
        assertThat(zamowienieController.allZamowienieByKlient(klient).size()).isIn(0);
    }

    @Test
    void getAllByClientsReturnsCorrectListWhenListIsNotEmpty() {
        Klient klient = new Klient(1, "adam", "małysz", "elo@cos.pl");
        Zamowienie zamowienie = new Zamowienie(1, klient);
        List<Zamowienie> zamowienies = new ArrayList<>();
        zamowienies.add(zamowienie);

        when(zamowienieRepository.getZamowienieFromKlient(any(Klient.class))).thenReturn(zamowienies);

        assertThat(zamowienieController.allZamowienieByKlient(klient).size()).isEqualTo(1);
    }

    @Test
    void getAllDetailZamowienie_przedmiotReturnsNullListNull() {
        when(zamowienie_przedmiotRepository.getAll()).thenReturn(null);
        assertNull(zamowienie_przedmiotRepository.getAll());
    }

    @Test
    void getAllDetailZamowienie_przedmiotReturnsCorrectList() {
        Zamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_Przedmiot(1, 1);
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();
        zamowienie_przedmiots.add(zamowienie_przedmiot);
        when(zamowienie_przedmiotRepository.getAll()).thenReturn(zamowienie_przedmiots);
        assertThat(zamowienie_przedmiotRepository.getAll().size()).isEqualTo(1);
    }

    @Test
    void getAllZamowienieReturnsNullWhenZamowienieEmpty() {
        when(zamowienieRepository.getAll()).thenReturn(null);
        assertNull(zamowienieRepository.getAll());
    }

    @Test
    void getAllZamowienieReturnsZamowieniesListWhenProper() {
        Klient klient = new Klient(1, "zbysiu", "chcespac", "Jestczwartaajaniespie@pandamax.pl");
        Zamowienie zamowienie = new Zamowienie(1, klient);
        Zamowienie zamowienie2 = new Zamowienie(1, klient);
        Zamowienie zamowienie3 = new Zamowienie(1, klient);


        List<Zamowienie> zamowienies = new ArrayList<>();
        zamowienies.add(zamowienie);
        zamowienies.add(zamowienie2);
        zamowienies.add(zamowienie3);


        when(zamowienieRepository.getAll()).thenReturn(zamowienies);
        assertThat(zamowienieRepository.getAll().size()).isEqualTo(3);
    }

    @Test
    void getByIdZamowienieReturnsNullWhenZamowienieDoesntExist() {
        when(zamowienieRepository.getZamowienie(any(Integer.class))).thenReturn(null);
        assertNull(zamowienieRepository.getZamowienie(1));
    }

    @Test
    void getZamowienieReturnsCorrectIdZamowienieWhenProper() {

        Klient klient = new Klient(1, "zbysiu", "chcespac", "Jestczwartaajaniespie@pandamax.pl");
        Zamowienie zamowienie = new Zamowienie(1, klient);
        when(zamowienieRepository.getZamowienie(1)).thenReturn(zamowienie);
        assertEquals(zamowienieRepository.getZamowienie(1).getId(), 1);
    }


}
