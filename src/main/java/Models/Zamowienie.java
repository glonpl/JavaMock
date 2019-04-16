package Models;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    public int Id;
 Klient klient;
 List<Przedmiot> koszyk = new ArrayList<Przedmiot>();

    public Zamowienie(int id, Klient klient, List<Przedmiot> koszyk) {
        Id = id;
        this.klient = klient;
        this.koszyk = koszyk;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public List<Przedmiot> getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(List<Przedmiot> koszyk) {
        this.koszyk = koszyk;
    }
}
