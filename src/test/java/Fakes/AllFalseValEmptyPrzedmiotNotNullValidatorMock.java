package Fakes;

import Models.Klient;
import Models.Przedmiot;
import Models.Zamowienie;
import Validations.IValidation;

public class AllFalseValEmptyPrzedmiotNotNullValidatorMock implements IValidation {
    @Override
    public boolean KlientValid(Klient klient) {
        return false;
    }

    @Override
    public boolean KlientNull(Klient klient) {
        return true;
    }

    @Override
    public boolean PrzedmiotValid(Przedmiot przedmiot) {
        return false;
    }

    @Override
    public boolean PrzedmiotNull(Przedmiot przedmiot) {
        return false;
    }

    @Override
    public boolean ZamowienieNull(Zamowienie zamowienie) {
        return true;
    }
}
