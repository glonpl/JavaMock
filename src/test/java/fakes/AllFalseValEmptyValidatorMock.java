package fakes;

import models.Klient;
import models.Przedmiot;
import models.Zamowienie;
import validations.IValidation;

public class AllFalseValEmptyValidatorMock implements IValidation {
    @Override
    public boolean klientValid(Klient klient) {
        return false;
    }

    @Override
    public boolean klientNull(Klient klient) {
        return true;
    }

    @Override
    public boolean przedmiotValid(Przedmiot przedmiot) {
        return false;
    }

    @Override
    public boolean przedmiotNull(Przedmiot przedmiot) {
        return true;
    }

    @Override
    public boolean zamowienieNull(Zamowienie zamowienie) {
        return true;
    }
}
