package models;

public class Zamowienie_Przedmiot {
    public int ZamowienieID;
    public int PrzedmiotID;


    public Zamowienie_Przedmiot(int zamowienieID, int przedmiotID) {
        ZamowienieID = zamowienieID;
        PrzedmiotID = przedmiotID;
    }


    public int getPrzedmiotID() {
        return PrzedmiotID;
    }
}
