package fakes;

import interfaces.IZamowienie_Przedmiot;
import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;

import java.util.ArrayList;
import java.util.List;

public class ZamowieniePrzedmiotNullPrzedmiotMock implements IZamowienie_Przedmiot {
    @Override
    public List<Zamowienie_Przedmiot> getAll() {
        return null;
    }

    @Override
    public List<Zamowienie_Przedmiot> getAllByZamowienie(Zamowienie zamowienie) {
        return null;
    }

    @Override
    public List<Zamowienie_Przedmiot> getAllByPrzedmiot(Przedmiot przedmiot) {
        Zamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_Przedmiot(przedmiot.getId(), 1);
        List<Zamowienie_Przedmiot> zamowienie_przedmiots = new ArrayList<>();
        zamowienie_przedmiots.add(zamowienie_przedmiot);


        return zamowienie_przedmiots;
    }

    @Override
    public boolean addZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }

    @Override
    public boolean deleteZamowieniePrzedmiot(Zamowienie_Przedmiot zamowienie) {
        return false;
    }
}
