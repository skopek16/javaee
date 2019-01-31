package pl.bskop.javaee.zad05.service;

import pl.bskop.javaee.zad05.domain.Conditioner;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class ConditionerManager {

    private List<Conditioner> db = Collections.synchronizedList(new ArrayList<>());

    public void addConditioner(Conditioner conditioner) {
        db.add(conditioner);
    }

    public void deleteConditioner(Conditioner conditioner){
        db.remove(conditioner);
    }

    public List<Conditioner> getAllConditioners(){
        return db;
    }

    public void deleteAllConditioners(){
        db.clear();
    }
}
