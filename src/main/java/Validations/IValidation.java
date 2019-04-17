package Validations;

import Models.Klient;
import Models.Przedmiot;

public interface IValidation {
    boolean KlientValid(Klient klient);
    boolean KlientNull(Klient klient);
    boolean PrzedmiotValid(Przedmiot przedmiot);
}
