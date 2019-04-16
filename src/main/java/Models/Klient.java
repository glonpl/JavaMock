package Models;

public class Klient {
    public int Id;
    public String Imie;
    public String Nazwisko;
    public String Email;

    public Klient(String imie, String nazwisko, String email) {
        Imie = imie;
        Nazwisko = nazwisko;
        Email = email;
    }
}
