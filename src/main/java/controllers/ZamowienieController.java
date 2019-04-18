package controllers;

import interfaces.IPrzedmiot;
import interfaces.IZamowienie;
import interfaces.IZamowienie_Przedmiot;
import models.Klient;
import models.Przedmiot;
import models.Zamowienie;
import models.Zamowienie_Przedmiot;
import validations.IValidation;

import java.util.List;

public class ZamowienieController {
    private IZamowienie zamowienieRepository;
    private IZamowienie_Przedmiot zamowienie_przedmiotRepository;
    private IPrzedmiot przedmiotRepository;
    private IValidation validation;

    public ZamowienieController(IZamowienie _zamowienieRepository, IZamowienie_Przedmiot _zamowienie_przedmiotRepository, IPrzedmiot _przedmiotRepository, IValidation _validation) {

        zamowienieRepository = _zamowienieRepository;
        zamowienie_przedmiotRepository = _zamowienie_przedmiotRepository;
        przedmiotRepository = _przedmiotRepository;
        validation = _validation;
    }

    public boolean addPrzedmiotToZamowienie(Przedmiot przedmiot, Zamowienie zamowienie) {
        if ((validation.przedmiotNull(przedmiot)) || (validation.zamowienieNull(zamowienie))) {

            throw new IllegalArgumentException("Przedmiot or Zamowienie is null");
        }
        if (!zamowienie_przedmiotRepository.getAllByPrzedmiot(przedmiot).isEmpty()) {
            return false;
        }

        Zamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_Przedmiot(zamowienie.getId(), przedmiot.getId());
        return zamowienie_przedmiotRepository.AddZamowieniePrzedmiot(zamowienie_przedmiot);
    }

    public boolean deletePrzedmiotFromZamowienie(Przedmiot przedmiot, Zamowienie zamowienie) {
        if (validation.przedmiotNull(przedmiot)) {
            throw new IllegalArgumentException("Przedmiot is null");
        }

        if (validation.zamowienieNull(zamowienie)) {
            throw new IllegalArgumentException("Zamowienie is null");
        }

        if (zamowienie_przedmiotRepository.getAllByPrzedmiot(przedmiot).isEmpty()) {
            return false;
        }

        List<Zamowienie_Przedmiot> przedmiotInZamowienie = zamowienie_przedmiotRepository.getAllByZamowienie(zamowienie);
        for (Zamowienie_Przedmiot zamowieniePrzedmiot : przedmiotInZamowienie) {
            if (zamowieniePrzedmiot.getPrzedmiotID() == przedmiot.getId()) {
                zamowienie_przedmiotRepository.deleteZamowieniePrzedmiot(zamowieniePrzedmiot);
            }
        }

        return true;
    }

    public boolean AddZamowienie(Zamowienie zamowienie) {
        if (validation.zamowienieNull(zamowienie)) {
            throw new IllegalArgumentException("Zamowienie is null");
        }

        return zamowienieRepository.AddZamowienie(zamowienie);
    }

    public boolean updateZamowienie(Zamowienie zamowienie) {
        if (validation.zamowienieNull(zamowienie)) {
            throw new IllegalArgumentException("Zamowienie is null");
        }

        return zamowienieRepository.updateZamowienie(zamowienie);
    }

    public boolean deleteZamowienie(Zamowienie zamowienie) {
        if (validation.zamowienieNull(zamowienie)) {
            throw new IllegalArgumentException("Zamowienie is null");
        }

        return zamowienieRepository.deleteZamowienie(zamowienie);
    }


    public List<Zamowienie> AllZamowienieByKlient(Klient klient) {
        if (validation.klientNull(klient)) {
            throw new IllegalArgumentException("Klient is null");
        }

        return zamowienieRepository.getZamowienieFromKlient(klient);

    }
}
