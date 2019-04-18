package interfaces;

import models.Klient;

import java.util.List;

public interface IKlient {

    List<Klient> GetAll();

    Klient GetKlient(int klientId);

    boolean AddKlient(Klient klient);

    boolean DeleteKlient(Klient klient);

    boolean UpdateKlient(Klient klient);
}
