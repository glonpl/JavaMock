package Interfaces;
import Models.Zamowienie_Przedmiot;
import java.util.List;

public interface IZamowienie_Przedmiot {
    List<Zamowienie_Przedmiot> GetAll();
    List<Zamowienie_Przedmiot> GetPrzedmiotFromZamowienie(int zamowienieId);
    Zamowienie_Przedmiot GetZamowieniePrzedmiot(int przedmiotId);
    boolean AddZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie);
    boolean DeleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie);
}
