package Interfaces;
import Models.Przedmiot;
import java.util.List;

public interface IPrzedmiot {
    List<Przedmiot> GetAll();
    Przedmiot GetPrzedmiot(int przedmiotId);
    boolean AddPrzedmiot(Przedmiot przedmiot);
    boolean DeletePrzedmiot(Przedmiot przedmiot);
    boolean UpdatePrzedmiot(Przedmiot przedmiot);
}
