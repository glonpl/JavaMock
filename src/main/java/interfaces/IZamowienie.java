package interfaces;

import models.Klient;
import models.Zamowienie;

import java.util.List;

public interface IZamowienie {
    List<Zamowienie> GetAll();

    Zamowienie GetZamowienie(int zamowienieId);

    List<Zamowienie> GetZamowienieFromKlient(Klient klient);

    boolean AddZamowienie(Zamowienie zamowienie);

    boolean DeleteZamowienie(Zamowienie zamowienie);

    boolean UpdateZamowienie(Zamowienie zamowienie);
}
