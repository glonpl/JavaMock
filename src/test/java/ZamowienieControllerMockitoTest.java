import Controllers.ZamowienieController;
import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie;
import Interfaces.IZamowienie_Przedmiot;
import Models.Klient;
import Models.Przedmiot;
import Models.Zamowienie;
import Models.Zamowienie_Przedmiot;
import Validations.IValidation;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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
    void setup(){
        zamowienieRepository =  Mockito.mock(IZamowienie.class);
        zamowienie_przedmiotRepository = Mockito.mock(IZamowienie_Przedmiot.class);
        przedmiotRepository = Mockito.mock(IPrzedmiot.class);
        validator= Mockito.mock(IValidation.class);
        zamowienieController = new ZamowienieController(zamowienieRepository, zamowienie_przedmiotRepository,przedmiotRepository,validator);
    }
//crud
    @Test
    void AddZamowienieNullThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.AddZamowienie(zamowienie), "Zamowienie is null");
    }
    @Test
    void AddZamowienieProperReturnsTrue(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.AddZamowienie(zamowienie)).thenReturn(true);
        assertThat(zamowienieController.AddZamowienie(zamowienie)).isTrue();
    }
    @Test
    void UpdateZamowienieNullThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.UpdateZamowienie(zamowienie), "Zamowienie is null");
    }
    @Test
    void UpdateZamowienieProperReturnsTrue(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.UpdateZamowienie(zamowienie)).thenReturn(true);
        assertThat(zamowienieController.UpdateZamowienie(zamowienie)).isTrue();
    }
    @Test
    void UpdateZamowienieInProperReturnsFalse(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.UpdateZamowienie(zamowienie)).thenReturn(false);
        assertThat(zamowienieController.UpdateZamowienie(zamowienie)).isNotEqualTo(true);
    }
    @Test
    void DeleteZamowienieNullThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.DeleteZamowienie(zamowienie), "Zamowienie is null");
    }
    @Test
    void DeleteZamowienieProperReturnsTrue(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.DeleteZamowienie(zamowienie)).thenReturn(true);
        assertThat(zamowienieController.DeleteZamowienie(zamowienie)).isTrue();
    }
    @Test
    void DeleteZamowienieInProperReturnsFalse(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.DeleteZamowienie(zamowienie)).thenReturn(false);
        assertThat(zamowienieController.DeleteZamowienie(zamowienie)).isIn(false,1);
    }
    //add/delete przedmiot
    @Test
    void AddPrzedmiotToZamowienieZamowienieNullThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        Przedmiot przedmiot= new Przedmiot(1,"Debulbator",23.43);
        when(validator.ZamowienieNull(zamowienie)).thenReturn(true);
        when(validator.PrzedmiotNull(przedmiot)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.AddPrzedmiotToZamowienie(przedmiot,zamowienie), "Zamowienie or Przedmiot  is null");
    }
    @Test
    void AddPrzedmiotToZamowienieNullPrzedmiotPrzedmiotThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        Przedmiot przedmiot= new Przedmiot(1,"Debulbator",23.43);
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(validator.PrzedmiotNull(przedmiot)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.AddPrzedmiotToZamowienie(przedmiot,zamowienie), "Zamowienie or Przedmiot  is null");
    }
    @Test
    void AddPrzedmiotToZamowienieAndPrzedmiotNullPrzedmiotThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        Przedmiot przedmiot= new Przedmiot(1,"Debulbator",23.43);
        when(validator.ZamowienieNull(zamowienie)).thenReturn(true);
        when(validator.PrzedmiotNull(przedmiot)).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.AddPrzedmiotToZamowienie(przedmiot,zamowienie), "Zamowienie or Przedmiot  is null");
    }


    @Test
    void AddPrzedmiotToZamowienieReturnsFalseWhenPrzedmiotIsInZamowienie_przedmiot(){
        Przedmiot przedmiot = new Przedmiot(1,"Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0,new Klient(1,"adam","Malysz","amalysz@wp.pl"));
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();

        zamowienie_przedmiots.add(new Zamowienie_Przedmiot(1,1));

        when(zamowienie_przedmiotRepository.GetAllByPrzedmiot(przedmiot)).thenReturn(zamowienie_przedmiots);

        assertFalse(zamowienieController.AddPrzedmiotToZamowienie(przedmiot,zamowienie));
    }

    @Test
    void AddPrzedmiotToZamowienieReturnsTrueWhenPrzedmiotIsNotInZamowienie_przedmiot(){
        Przedmiot przedmiot = new Przedmiot(1,"Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0,new Klient(1,"adam","Malysz","amalysz@wp.pl"));
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();


        when(zamowienie_przedmiotRepository.GetAllByPrzedmiot(any(Przedmiot.class))).thenReturn(zamowienie_przedmiots);
        when(zamowienie_przedmiotRepository.AddZamowieniePrzedmiot(any(Zamowienie_Przedmiot.class))).thenReturn(true);

        assertTrue(zamowienieController.AddPrzedmiotToZamowienie(przedmiot,zamowienie));
    }

    @Test
    void DeletePrzedmiotFromZamowienieThrowsExceptionWhenBothAreNull(){
        Przedmiot przedmiot = new Przedmiot(1,"Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0,new Klient(1,"adam","Malysz","amalysz@wp.pl"));
        when(validator.PrzedmiotNull(przedmiot)).thenReturn(true);
        when(validator.ZamowienieNull(zamowienie)).thenReturn(true);

        when(zamowienie_przedmiotRepository.AddZamowieniePrzedmiot(any(Zamowienie_Przedmiot.class))).thenReturn(true);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.DeletePrzedmiotFromZamowienie(przedmiot,zamowienie));
    }

   @Test
    void DeletePrzedmiotFromZamowienieThrowsExceprionWhenZamowienieIsNull(){
       Przedmiot przedmiot = new Przedmiot(1,"Debulbator", 23.66);
       Zamowienie zamowienie = new Zamowienie(0,new Klient(1,"adam","Malysz","amalysz@wp.pl"));
       when(validator.PrzedmiotNull(przedmiot)).thenReturn(true);
       when(validator.ZamowienieNull(zamowienie)).thenReturn(false);

       assertThrows(IllegalArgumentException.class, () -> zamowienieController.DeletePrzedmiotFromZamowienie(przedmiot,zamowienie));
   }

    @Test
    void DeletePrzedmiotFromZamowienieReturnsFalseWhenPrzedmiotIsNotInzamowienieprzedmiot(){
        Przedmiot przedmiot = new Przedmiot(1,"Debulbator", 23.66);
        Zamowienie zamowienie = new Zamowienie(0,new Klient(1,"adam","Malysz","amalysz@wp.pl"));
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();


        when(zamowienie_przedmiotRepository.GetAllByPrzedmiot(any(Przedmiot.class))).thenReturn(zamowienie_przedmiots);

        assertThat(zamowienieController.DeletePrzedmiotFromZamowienie(przedmiot,zamowienie)).isIn(false);
    }

     @Test
    void DeletePrzedmiotFromZamowienieReturnsTrueWhenPrzedmiotIsInzamowienieprzedmiot(){
         Przedmiot przedmiot = new Przedmiot(1,"Debulbator", 23.66);
         Zamowienie zamowienie = new Zamowienie(0,new Klient(1,"adam","Malysz","amalysz@wp.pl"));
         List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();
         zamowienie_przedmiots.add(new Zamowienie_Przedmiot(1,1));


        when(zamowienie_przedmiotRepository.GetAllByPrzedmiot(any(Przedmiot.class))).thenReturn(zamowienie_przedmiots);
        when(zamowienie_przedmiotRepository.GetAllByZamowienie(any(Zamowienie.class))).thenReturn(zamowienie_przedmiots);
        when(zamowienie_przedmiotRepository.DeleteZamowieniePrzedmiot(any(Zamowienie_Przedmiot.class))).thenReturn(true);

        assertTrue(zamowienieController.DeletePrzedmiotFromZamowienie(przedmiot,zamowienie));
    }

    //getAll

    @Test
    void getAllByClientsShouldThrowWhenClientIsNull(){
        Klient klient=new Klient(1,"adam","małysz","elo@cos.pl");
        when(validator.KlientNull(klient)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> zamowienieController.AllZamowienieByKlient(klient));
    }

    @Test
    void getAllByClientsReturnsEmptyListWhenListIsEmpty(){
        Klient klient=new Klient(1,"adam","małysz","elo@cos.pl");
        List<Zamowienie> zamowienies = new ArrayList<>();
        when(zamowienieRepository.GetZamowienieFromKlient(any(Klient.class))).thenReturn(zamowienies);
        assertThat(zamowienieController.AllZamowienieByKlient(klient).size()).isIn(0);
    }

    @Test
    void getAllByClientsReturnsCorrectListWhenListIsNotEmpty(){
        Klient klient=new Klient(1,"adam","małysz","elo@cos.pl");
        Zamowienie zamowienie= new Zamowienie(1,klient);
                List<Zamowienie> zamowienies = new ArrayList<>();
                zamowienies.add(zamowienie);

        when(zamowienieRepository.GetZamowienieFromKlient(any(Klient.class))).thenReturn(zamowienies);

        assertThat(zamowienieController.AllZamowienieByKlient(klient).size()).isEqualTo(1);
    }

    @Test
    void getAllDetailZamowienie_przedmiotReturnsNullListNull(){
        when(zamowienie_przedmiotRepository.GetAll()).thenReturn(null);
        assertNull(zamowienie_przedmiotRepository.GetAll());
    }

    @Test
    void getAllDetailZamowienie_przedmiotReturnsCorrectList(){
        Zamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_Przedmiot(1,1);
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();
        zamowienie_przedmiots.add(zamowienie_przedmiot);
        when(zamowienie_przedmiotRepository.GetAll()).thenReturn(zamowienie_przedmiots);
        assertThat(zamowienie_przedmiotRepository.GetAll().size()).isEqualTo(1);
    }

    @Test
    void getAllZamowienieReturnsNullWhenZamowienieEmpty(){
        when(zamowienieRepository.GetAll()).thenReturn(null);
        assertNull(zamowienieRepository.GetAll());
    }

    @Test
    void getAllZamowienieReturnsZamowieniesListWhenProper(){
        Klient klient= new Klient(1,"zbysiu","chcespac","Jestczwartaajaniespie@pandamax.pl");
        Zamowienie zamowienie = new Zamowienie(1,klient);
        Zamowienie zamowienie2 = new Zamowienie(1,klient);
        Zamowienie zamowienie3 = new Zamowienie(1,klient);


        List<Zamowienie> zamowienies = new ArrayList<>();
        zamowienies.add(zamowienie);
        zamowienies.add(zamowienie2);
        zamowienies.add(zamowienie3);


        when(zamowienieRepository.GetAll()).thenReturn(zamowienies);
        assertThat(zamowienieRepository.GetAll().size()).isEqualTo(3);
    }

    @Test
    void getByIdZamowienieReturnsNullWhenZamowienieDoesntExist(){
        when(zamowienieRepository.GetZamowienie(any(Integer.class))).thenReturn(null);
        assertNull(zamowienieRepository.GetZamowienie(1));
    }

    @Test
    void GetZamowienieReturnsCorrectIdZamowienieWhenProper(){

        Klient klient= new Klient(1,"zbysiu","chcespac","Jestczwartaajaniespie@pandamax.pl");
        Zamowienie zamowienie = new Zamowienie(1,klient);
        when(zamowienieRepository.GetZamowienie(1)).thenReturn(zamowienie);
        assertEquals(zamowienieRepository.GetZamowienie(1).getId(), 1);
    }


}
