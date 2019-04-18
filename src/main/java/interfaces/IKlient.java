package interfaces;

import models.Klient;

import java.util.List;

public interface IKlient {

    List<Klient> getAll();

    Klient getKlient(int klientId);

    boolean addKlient(Klient klient);

    boolean deleteKlient(Klient klient);

    boolean updateKlient(Klient klient);
}
