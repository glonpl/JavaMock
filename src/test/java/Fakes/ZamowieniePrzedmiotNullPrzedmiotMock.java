package Fakes;

import Interfaces.IZamowienie_Przedmiot;
import Models.Przedmiot;
import Models.Zamowienie;
import Models.Zamowienie_Przedmiot;

import java.util.List;

public class ZamowieniePrzedmiotNullPrzedmiotMock implements IZamowienie_Przedmiot {
    @Override
    public List<Zamowienie_Przedmiot> GetAll() {
        return null;
    }

    @Override
    public List<Zamowienie_Przedmiot> GetAllByZamowienie(Zamowienie zamowienie) {
        return null;
    }

    @Override
    public List<Zamowienie_Przedmiot> GetAllByPrzedmiot(Przedmiot przedmiot) {
        return null;
    }

    @Override
    public boolean AddZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }

    @Override
    public boolean DeleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }
}
