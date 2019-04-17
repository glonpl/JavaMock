package Controllers;

import Interfaces.IPrzedmiot;
import Interfaces.IZamowienie;
import Interfaces.IZamowienie_Przedmiot;
import Models.Klient;
import Models.Przedmiot;
import Models.Zamowienie;
import Models.Zamowienie_Przedmiot;
import Validations.IValidation;

import java.util.List;

public class ZamowienieController {
    private IZamowienie zamowienieRepository;
    private IZamowienie_Przedmiot zamowienie_przedmiotRepository;
    private IPrzedmiot przedmiotRepository;
    private IValidation validation;

    public ZamowienieController(IZamowienie _zamowienieRepository, IZamowienie_Przedmiot _zamowienie_przedmiotRepository, IPrzedmiot _przedmiotRepository,IValidation _validation) {

        zamowienieRepository = _zamowienieRepository;
        zamowienie_przedmiotRepository = _zamowienie_przedmiotRepository;
        przedmiotRepository = _przedmiotRepository;
        validation=_validation;
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
    public boolean DeletePrzedmiotFromZamowienie(Przedmiot przedmiot, Zamowienie zamowienie){
        if(validation.PrzedmiotNull(przedmiot)){
            throw new IllegalArgumentException("Przedmiot is null");
        }

        if(validation.ZamowienieNull(zamowienie)){
            throw new IllegalArgumentException("Zamowienie is null");
        }

        if(zamowienie_przedmiotRepository.GetAllByPrzedmiot(przedmiot).isEmpty()){
            return false;
        }

        List<Zamowienie_Przedmiot> przedmiotInZamowienie = zamowienie_przedmiotRepository.GetAllByZamowienie(zamowienie);
        for(Zamowienie_Przedmiot zamowieniePrzedmiot : przedmiotInZamowienie){
            if(zamowieniePrzedmiot.getPrzedmiotID() == przedmiot.getId()){
                zamowienie_przedmiotRepository.DeleteZamowieniePrzedmiot(zamowieniePrzedmiot);
            }
        }

        return true;
    }

    public boolean AddZamowienie(Zamowienie zamowienie){
        if(validation.ZamowienieNull(zamowienie)){
            throw new IllegalArgumentException("Zamowienie is null");
        }

        return zamowienieRepository.AddZamowienie(zamowienie);
    }

    public boolean UpdateZamowienie(Zamowienie zamowienie){
        if(validation.ZamowienieNull(zamowienie)){
            throw new IllegalArgumentException("Zamowienie is null");
        }

        return zamowienieRepository.UpdateZamowienie(zamowienie);
    }

    public boolean DeleteZamowienie(Zamowienie zamowienie){
        if(validation.ZamowienieNull(zamowienie)){
            throw new IllegalArgumentException("Zamowienie is null");
        }

        return zamowienieRepository.DeleteZamowienie(zamowienie);
    }


    public List<Zamowienie> AllZamowienieByKlient(Klient klient){
        if(validation.KlientNull(klient)){
            throw new IllegalArgumentException("Klient is null");
        }

        return zamowienieRepository.GetZamowienieFromKlient(klient.getId());

    }
}
