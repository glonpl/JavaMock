package fakes;

import interfaces.IPrzedmiot;
import models.Przedmiot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrzedmiotMock implements IPrzedmiot {

    Map<Integer, Przedmiot> przedmiots = new HashMap<>();

    @Override
    public List<Przedmiot> getAll() {
        return new ArrayList<>(przedmiots.values());
    }

    @Override
    public Przedmiot getPrzedmiot(int przedmiotId) {
        return przedmiots.get(przedmiotId);
    }

    @Override
    public boolean addPrzedmiot(Przedmiot przedmiot) {
        if (przedmiots.size() == 0) {
            przedmiot.setId(0);
        } else {
            int previous = przedmiots.get(przedmiots.size() - 1).getId();
            przedmiot.setId(previous + 1);
        }
        przedmiots.put(przedmiot.getId(), przedmiot);
        return true;
    }

    @Override
    public boolean deletePrzedmiot(Przedmiot przedmiot) {

        if (przedmiot == null) {
            throw new NullPointerException();
        }

        przedmiots.remove(przedmiot.getId());
        return true;
    }


    @Override
    public boolean updatePrzedmiot(Przedmiot przedmiot) {
        if (przedmiot == null) {
            throw new NullPointerException();
        }

        if (!przedmiots.containsKey(przedmiot.getId())) {
            throw new IllegalArgumentException();
        }

        przedmiots.remove(przedmiot.getId());
        przedmiots.put(przedmiot.getId(), przedmiot);
        return true;

    }
}
