import Controllers.ZamowienieController;
import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie;
import Interfaces.IZamowienie_Przedmiot;
import Models.Klient;
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
}
