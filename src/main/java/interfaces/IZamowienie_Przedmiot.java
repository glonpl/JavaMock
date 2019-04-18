package interfaces;

import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;

import java.util.List;

public interface IZamowienie_Przedmiot {
    List<Zamowienie_Przedmiot> GetAll();

    List<Zamowienie_Przedmiot> GetAllByZamowienie(Zamowienie zamowienie);

    List<Zamowienie_Przedmiot> GetAllByPrzedmiot(Przedmiot przedmiot);

    boolean AddZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie);

    boolean DeleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie);
}
