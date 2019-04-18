package interfaces;

import models.Przedmiot;

import java.util.List;

public interface IPrzedmiot {
    List<Przedmiot> getAll();

    Przedmiot getPrzedmiot(int przedmiotId);

    boolean addPrzedmiot(Przedmiot przedmiot);

    boolean deletePrzedmiot(Przedmiot przedmiot);

    boolean updatePrzedmiot(Przedmiot przedmiot);
}
