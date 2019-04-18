package controllers;

import interfaces.IKlient;
import interfaces.IZamowienie;
import models.Klient;
import validations.IValidation;

import java.util.List;

public class KlientController {
    private IValidation validator;
    private IKlient klientRepository;
    private IZamowienie zamowienieRepository;

    public KlientController(IKlient _klientRepository, IValidation _validator, IZamowienie _zamowienieRepository) {
        klientRepository = _klientRepository;
        zamowienieRepository = _zamowienieRepository;
        validator = _validator;
    }

    public List<Klient> getAll() {
        return klientRepository.getAll();
    }

    public Klient getKlient(int klientId) {
        return klientRepository.getKlient(klientId);
    }

    public boolean addKlient(Klient klient) {
        if (validator.klientNull(klient)) {
            throw new IllegalArgumentException("klient is null");
        }
        if (validator.klientValid(klient)) {
            return klientRepository.addKlient(klient);
        }
        return false;
    }

    public boolean deleteKlient(Klient klient) {
        if (validator.klientNull(klient)) {
            throw new IllegalArgumentException("klient is null");
        }
        if (klientRepository.getKlient(klient.getId()) == null) {
            return false;
        }
        if (!zamowienieRepository.getZamowienieFromKlient(klient).isEmpty()) {
            return false;
        }
        return klientRepository.deleteKlient(klient);
    }

    public boolean updateKlient(Klient klient) {
        if (validator.klientNull(klient)) {
            throw new IllegalArgumentException("klient is null");
        }
        if (!validator.klientValid(klient)) {
            return false;
        }
        if (klientRepository.getKlient(klient.getId()) == null) {
            return false;
        }
        return klientRepository.updateKlient(klient);
    }


}

