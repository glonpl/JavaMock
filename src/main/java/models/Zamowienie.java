package models;

public class Zamowienie {
    public int Id;
    public Klient klient;


    public Zamowienie(int id, Klient klient) {
        Id = id;
        this.klient = klient;
    }

    public int getId() {
        return Id;
    }


}
