package Controllers;

import Interfaces.IKlient;
import Models.Klient;

import java.util.List;

public class KlientController {
    private IKlient klientRepository;
    public List<Klient> GetAll(){}
    public boolean AddKlient (Klient klient){}
    public boolean DeleteKlient (Klient klient){}
    public boolean UpdateKlient (Klient klient){}

}
