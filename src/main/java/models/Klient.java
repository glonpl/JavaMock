package models;

public class Klient {
    public int Id;
    public String Imie;
    public String Nazwisko;
    public String Email;

    public Klient(int id, String imie, String nazwisko, String email) {
        Id = id;
        Imie = imie;
        Nazwisko = nazwisko;
        Email = email;
    }

    public int getId() {
        return Id;
    }


}
