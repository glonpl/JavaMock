package interfaces;

import models.Klient;
import models.Zamowienie;

import java.util.List;

public interface IZamowienie {
    List<Zamowienie> getAll();

    Zamowienie GetZamowienie(int zamowienieId);

    List<Zamowienie> GetZamowienieFromKlient(Klient klient);

    boolean AddZamowienie(Zamowienie zamowienie);

    boolean DeleteZamowienie(Zamowienie zamowienie);

    boolean updateZamowienie(Zamowienie zamowienie);
}
