package fakes;

import interfaces.IZamowienie_Przedmiot;
import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie_PrzedmiotMock implements IZamowienie_Przedmiot {
    public List<Zamowienie_Przedmiot> getAll() {
        return null;
    }

    public List<Zamowienie_Przedmiot> getAllByZamowienie(Zamowienie zamowienie) {
        return null;
    }

    public List<Zamowienie_Przedmiot> getAllByPrzedmiot(Przedmiot przedmiot) {
        return new ArrayList<>();
    }

    public boolean AddZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }

    public boolean deleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return true;
    }
}
