package Models;

public class Przedmiot {
    public int Id;
    public String Nazwa;
    public double Wartosc;


    public Przedmiot(int id, String nazwa, double wartosc) {
        this.Id = id;
        this.Nazwa = nazwa;
        this.Wartosc = wartosc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public double getWartosc() {
        return Wartosc;
    }

    public void setWartosc(double wartosc) {
        Wartosc = wartosc;
    }
}
