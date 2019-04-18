package validations;

import models.Klient;
import models.Przedmiot;
import models.Zamowienie;

public interface IValidation {
    boolean klientValid(Klient klient);

    boolean klientNull(Klient klient);

    boolean przedmiotValid(Przedmiot przedmiot);

    boolean przedmiotNull(Przedmiot przedmiot);

    boolean zamowienieNull(Zamowienie zamowienie);
}
