package Mock;

import Interfaces.IPrzedmiot;
import Models.Przedmiot;

import java.util.List;

public class PrzedmiotMock implements IPrzedmiot {
    public List<Przedmiot> GetAll() {
        return null;
    }

    public Przedmiot GetPrzedmiot(int przedmiotId) {
        return null;
    }

    public boolean AddPrzedmiot(Przedmiot przedmiot) {
        return false;
    }

    public boolean DeletePrzedmiot(Przedmiot przedmiot) {
        return false;
    }

    public boolean UpdatePrzedmiot(Przedmiot przedmiot) {
        return false;
    }
}
