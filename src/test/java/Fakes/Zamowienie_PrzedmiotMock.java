package Fakes;

import Interfaces.IZamowienie_Przedmiot;
import Models.Przedmiot;
import Models.Zamowienie;
import Models.Zamowienie_Przedmiot;

import java.util.List;

public class Zamowienie_PrzedmiotMock implements IZamowienie_Przedmiot {
    public List<Zamowienie_Przedmiot> GetAll() {
        return null;
    }

    public List<Zamowienie_Przedmiot> GetAllByZamowienie(Zamowienie zamowienie) {
        return null;
    }

    public List<Zamowienie_Przedmiot> GetAllByPrzedmiot(Przedmiot przedmiot) {
        return null;
    }

    public boolean AddZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }

    public boolean DeleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }
}
