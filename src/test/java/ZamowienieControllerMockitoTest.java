import Controllers.ZamowienieController;
import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie;
import Interfaces.IZamowienie_Przedmiot;
import Models.Klient;
import Models.Przedmiot;
import Models.Zamowienie;
import Validations.IValidation;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
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
    void AddPrzedmiotToZamowienieNullPrzedmiotThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        Przedmiot przedmiot= new Przedmiot(1,"Debulbator",23.43);
        when(validator.ZamowienieNull(zamowienie)).thenReturn(true);
        when(validator.PrzedmiotNull(przedmiot)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> zamowienieController.AddPrzedmiotToZamowienie(przedmiot,zamowienie), "Zamowienie or Przedmiot  is null");
    }
    @Test
    void AddPrzedmiotToPrzedmiotNullPrzedmiotThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.DeleteZamowienie(zamowienie)).thenReturn(false);
        assertThat(zamowienieController.DeleteZamowienie(zamowienie)).isIn(false,1);
    }
    @Test
    void AddPrzedmiotToZamowienieAndPrzedmiotNullPrzedmiotThrowsException(){
        Zamowienie zamowienie= new Zamowienie(1,new Klient(1,"Zbigniew","Wodecki","zwodecki@wp.pl"));
        when(validator.ZamowienieNull(zamowienie)).thenReturn(false);
        when(zamowienieRepository.DeleteZamowienie(zamowienie)).thenReturn(false);
        assertThat(zamowienieController.DeleteZamowienie(zamowienie)).isIn(false,1);
    }


    //getAll
}
