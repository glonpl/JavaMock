package Validations;

import Models.Klient;
import Models.Przedmiot;
import Models.Zamowienie;

public interface IValidation {
    boolean KlientValid(Klient klient);
    boolean KlientNull(Klient klient);
    boolean PrzedmiotValid(Przedmiot przedmiot);
    boolean PrzedmiotNull(Przedmiot przedmiot);
    boolean ZamowienieNull(Zamowienie zamowienie);
    boolean Zamowienievalid(Zamowienie zamowienie);
}
