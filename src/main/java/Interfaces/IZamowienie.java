package Interfaces;
import Models.Zamowienie;
import java.util.List;

public interface IZamowienie {
    List<Zamowienie> GetAll();
    Zamowienie GetZamowienie(int zamowienieId);
    List<Zamowienie> GetZamowienieFromKlient(int klientId);
    boolean AddZamowienie(Zamowienie zamowienie);
    boolean DeleteZamowienie(Zamowienie zamowienie);
    boolean UpdateZamowienie(Zamowienie zamowienie);
}
