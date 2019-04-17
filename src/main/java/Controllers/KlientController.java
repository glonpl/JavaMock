package Controllers;
        import Interfaces.IKlient;
        import Models.Klient;
        import java.util.List;
        import Validations.IValidation;
public class KlientController {

    private IKlient klientRepository;
    public KlientController(IKlient _klientRepository){
        klientRepository = _klientRepository;
    }

    public List<Klient> GetAll(){return klientRepository.GetAll();}
    public Klient GetKlient(int klientId){return klientRepository.GetKlient(klientId);}
    public boolean AddKlient (Klient klient){if(IValidation.KlientValid(klient)){return klientRepository.AddKlient(klient);}return false;}
    public boolean DeleteKlient (Klient klient){}
    public boolean UpdateKlient (Klient klient){}

}

//DODAJ VALIDATOR klient==null => false
