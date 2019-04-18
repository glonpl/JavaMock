package controllers;


import interfaces.IPrzedmiot;
import interfaces.IZamowienie_Przedmiot;
import models.Przedmiot;
import validations.IValidation;

public class PrzedmiotController {
    private IValidation validator;
    private IPrzedmiot przedmiotRepository;
    private IZamowienie_Przedmiot zamowieniePrzedmiotRepository;


    public PrzedmiotController(IValidation _validator, IPrzedmiot _przedmiotRepository, IZamowienie_Przedmiot _zamowieniePRepository) {
        validator = _validator;
        przedmiotRepository = _przedmiotRepository;
        zamowieniePrzedmiotRepository = _zamowieniePRepository;
    }

    public boolean AddPrzedmiot(Przedmiot przedmiot) {

        if (validator.PrzedmiotNull(przedmiot)) {
            throw new IllegalArgumentException("przedmiot is null");
        }

        if (!validator.PrzedmiotValid(przedmiot)) {
            return false;
        }

        return przedmiotRepository.AddPrzedmiot(przedmiot);
    }

    public boolean updatePrzedmiot(Przedmiot przedmiot) {

        if (validator.PrzedmiotNull(przedmiot)) {
            throw new IllegalArgumentException("przedmiot is null");
        }

        if (!validator.PrzedmiotValid(przedmiot)) {
            return false;
        }

        if (przedmiotRepository.GetPrzedmiot(przedmiot.getId()) == null) {
            return false;
        }

        return przedmiotRepository.updatePrzedmiot(przedmiot);
    }

    public boolean DeletePrzedmiot(Przedmiot przedmiot) {
        if (validator.PrzedmiotNull(przedmiot)) {
            throw new IllegalArgumentException("przedmiot is null");
        }

        if (przedmiotRepository.GetPrzedmiot(przedmiot.getId()) == null) {
            return false;
        }

        if (!zamowieniePrzedmiotRepository.getAllByPrzedmiot(przedmiot).isEmpty()) {
            return false;
        }

        return przedmiotRepository.DeletePrzedmiot(przedmiot);
    }


}
