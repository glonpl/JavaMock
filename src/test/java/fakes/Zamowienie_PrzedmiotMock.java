package fakes;

import interfaces.IZamowienie_Przedmiot;
import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie_PrzedmiotMock implements IZamowienie_Przedmiot {
    public List<Zamowienie_Przedmiot> GetAll() {
        return null;
    }

    public List<Zamowienie_Przedmiot> GetAllByZamowienie(Zamowienie zamowienie) {
        return null;
    }

    public List<Zamowienie_Przedmiot> GetAllByPrzedmiot(Przedmiot przedmiot) {
        return new ArrayList<>();
    }

    public boolean AddZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }

    public boolean DeleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return true;
    }
}
