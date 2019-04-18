package interfaces;

import models.Przedmiot;

import java.util.List;

public interface IPrzedmiot {
    List<Przedmiot> getAll();

    Przedmiot GetPrzedmiot(int przedmiotId);

    boolean AddPrzedmiot(Przedmiot przedmiot);

    boolean DeletePrzedmiot(Przedmiot przedmiot);

    boolean updatePrzedmiot(Przedmiot przedmiot);
}
