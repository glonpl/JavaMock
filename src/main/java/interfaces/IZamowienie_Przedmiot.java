package interfaces;

import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;

import java.util.List;

public interface IZamowienie_Przedmiot {
    List<Zamowienie_Przedmiot> getAll();

    List<Zamowienie_Przedmiot> getAllByZamowienie(Zamowienie zamowienie);

    List<Zamowienie_Przedmiot> getAllByPrzedmiot(Przedmiot przedmiot);

    boolean AddZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie);

    boolean deleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie);
}
