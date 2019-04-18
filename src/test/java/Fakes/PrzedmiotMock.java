package Fakes;

import Interfaces.IPrzedmiot;
import Models.Przedmiot;
import Validations.IValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrzedmiotMock implements IPrzedmiot {

    Map<Integer, Przedmiot> przedmiots = new HashMap<>();
    @Override
    public List<Przedmiot> GetAll() {
        return new ArrayList<>(przedmiots.values());
    }
    @Override
    public Przedmiot GetPrzedmiot(int przedmiotId) { return  przedmiots.get(przedmiotId); }
    @Override
    public boolean AddPrzedmiot(Przedmiot przedmiot) {
        if(przedmiots.size()==0){
            przedmiot.setId(0);
        }else{
            int previous = przedmiots.get(przedmiots.size()-1).getId();
            przedmiot.setId(previous + 1);
        }
        przedmiots.put(przedmiot.getId(),przedmiot);
        return true;
    }
    @Override
    public boolean DeletePrzedmiot(Przedmiot przedmiot) {

        if(przedmiot == null){
            throw new NullPointerException();
        }

        przedmiots.remove(przedmiot.getId());
        return true;
    }


    @Override
    public boolean UpdatePrzedmiot(Przedmiot przedmiot) {
            if(przedmiot==null){
                throw new NullPointerException();
            }

            if(!przedmiots.containsKey(przedmiot.getId())){
                throw new IllegalArgumentException();
            }

            przedmiots.remove(przedmiot.getId());
            przedmiots.put(przedmiot.getId(), przedmiot);
            return true;

    }
}