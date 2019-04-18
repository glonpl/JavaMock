package interfaces;

import models.Klient;
import models.Zamowienie;

import java.util.List;

public interface IZamowienie {
    List<Zamowienie> getAll();

    Zamowienie getZamowienie(int zamowienieId);

    List<Zamowienie> getZamowienieFromKlient(Klient klient);

    boolean AddZamowienie(Zamowienie zamowienie);

    boolean deleteZamowienie(Zamowienie zamowienie);

    boolean updateZamowienie(Zamowienie zamowienie);
}
