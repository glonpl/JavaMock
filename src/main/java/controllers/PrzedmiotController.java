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

    public boolean addPrzedmiot(Przedmiot przedmiot) {

        if (validator.przedmiotNull(przedmiot)) {
            throw new IllegalArgumentException("przedmiot is null");
        }

        if (!validator.przedmiotValid(przedmiot)) {
            return false;
        }

        return przedmiotRepository.addPrzedmiot(przedmiot);
    }

    public boolean updatePrzedmiot(Przedmiot przedmiot) {

        if (validator.przedmiotNull(przedmiot)) {
            throw new IllegalArgumentException("przedmiot is null");
        }

        if (!validator.przedmiotValid(przedmiot)) {
            return false;
        }

        if (przedmiotRepository.getPrzedmiot(przedmiot.getId()) == null) {
            return false;
        }

        return przedmiotRepository.updatePrzedmiot(przedmiot);
    }

    public boolean deletePrzedmiot(Przedmiot przedmiot) {
        if (validator.przedmiotNull(przedmiot)) {
            throw new IllegalArgumentException("przedmiot is null");
        }

        if (przedmiotRepository.getPrzedmiot(przedmiot.getId()) == null) {
            return false;
        }

        if (!zamowieniePrzedmiotRepository.getAllByPrzedmiot(przedmiot).isEmpty()) {
            return false;
        }

        return przedmiotRepository.deletePrzedmiot(przedmiot);
    }


}
