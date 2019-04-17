package Controllers;

import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie;
import Interfaces.IZamowienie_Przedmiot;
import Models.Przedmiot;
import Models.Zamowienie;
import Models.Zamowienie_Przedmiot;
import Validations.IValidation;

public class ZamowienieController {
    private IZamowienie zamowienieRepository;
    private IZamowienie_Przedmiot zamowienie_przedmiotRepository;
    private IPrzedmiot przedmiotRepository;
    private IValidation validation;

    public ZamowienieController(IZamowienie _zamowienieRepository, IZamowienie_Przedmiot _zamowienie_przedmiotRepository, IPrzedmiot _przedmiotRepository) {

        zamowienieRepository = _zamowienieRepository;
        zamowienie_przedmiotRepository = _zamowienie_przedmiotRepository;
        przedmiotRepository = _przedmiotRepository;
    }
    public boolean AddPrzedmiotToZamowienie(Przedmiot przedmiot, Zamowienie zamowienie){
        if (!validation.PrzedmiotNull(przedmiot)||!validation.ZamowienieNull(zamowienie)) {
            throw new IllegalArgumentException("Przedmiot or Zamowienie is null");
        }
        if(!zamowienie_przedmiotRepository.GetAllByPrzedmiot(przedmiot).isEmpty()){
            return false;
        }

        Zamowienie_Przedmiot zamowienie_przedmiot = new Zamowienie_Przedmiot(zamowienie.getId(), przedmiot.getId());
        return zamowienie_przedmiotRepository.AddZamowieniePrzedmiot(zamowienie_przedmiot);
    }
}
