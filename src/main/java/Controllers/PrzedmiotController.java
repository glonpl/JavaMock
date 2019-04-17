package Controllers;


import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie;
import Validations.IValidation;

public class PrzedmiotController {
    private IValidation validator;
    private IPrzedmiot przedmiotRepository;
    private IZamowienie zamowienieRepository;


    public PrzedmiotController(IValidation validator, IPrzedmiot przedmiotRepository, IZamowienie zamowienieRepository) {
        this.validator = validator;
        this.przedmiotRepository = przedmiotRepository;
        this.zamowienieRepository = zamowienieRepository;
    }
}
