package validations;

import models.Klient;
import models.Przedmiot;
import models.Zamowienie;

public interface IValidation {
    boolean KlientValid(Klient klient);

    boolean KlientNull(Klient klient);

    boolean PrzedmiotValid(Przedmiot przedmiot);

    boolean PrzedmiotNull(Przedmiot przedmiot);

    boolean ZamowienieNull(Zamowienie zamowienie);
}
