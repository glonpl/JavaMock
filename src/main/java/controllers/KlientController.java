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

    public List<Klient> GetAll() {
        return klientRepository.GetAll();
    }

    public Klient GetKlient(int klientId) {
        return klientRepository.GetKlient(klientId);
    }

    public boolean AddKlient(Klient klient) {
        if (validator.KlientNull(klient)) {
            throw new IllegalArgumentException("klient is null");
        }
        if (validator.KlientValid(klient)) {
            return klientRepository.AddKlient(klient);
        }
        return false;
    }

    public boolean DeleteKlient(Klient klient) {
        if (validator.KlientNull(klient)) {
            throw new IllegalArgumentException("klient is null");
        }
        if (klientRepository.GetKlient(klient.getId()) == null) {
            return false;
        }
        if (!zamowienieRepository.GetZamowienieFromKlient(klient).isEmpty()) {
            return false;
        }
        return klientRepository.DeleteKlient(klient);
    }

    public boolean UpdateKlient(Klient klient) {
        if (validator.KlientNull(klient)) {
            throw new IllegalArgumentException("klient is null");
        }
        if (!validator.KlientValid(klient)) {
            return false;
        }
        if (klientRepository.GetKlient(klient.getId()) == null) {
            return false;
        }
        return klientRepository.UpdateKlient(klient);
    }


}
