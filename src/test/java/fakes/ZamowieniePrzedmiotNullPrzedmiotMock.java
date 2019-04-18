package fakes;

import interfaces.IZamowienie_Przedmiot;
import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;

import java.util.ArrayList;
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

        return new ArrayList<>();
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
