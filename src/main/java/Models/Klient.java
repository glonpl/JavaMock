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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
