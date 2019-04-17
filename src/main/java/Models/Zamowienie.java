package Models;

import java.util.List;

public class Zamowienie {
    public int Id;
 Klient klient;


    public Zamowienie(int id, Klient klient) {
        Id = id;
        this.klient = klient;
    }

    public int getId() {
        return Id;
    }


}
