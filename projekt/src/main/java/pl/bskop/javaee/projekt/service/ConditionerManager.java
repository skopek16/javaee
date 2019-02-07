package pl.bskop.javaee.projekt.service;

import pl.bskop.javaee.projekt.domain.Conditioner;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ConditionerManager {

    @PersistenceContext
    EntityManager entityManager;

    public void addConditioner(Conditioner conditioner) {
        entityManager.persist(conditioner);
    }

    public Conditioner getConditioner(long id){
        return entityManager.find(Conditioner.class, id);
    }

    public Conditioner updateConditioner(Conditioner transientConditioner) {
        return entityManager.merge(transientConditioner);
    }

    public void deleteConditioner(long id){
        Conditioner conditioner = entityManager.find(Conditioner.class, id);

        entityManager.remove(conditioner);
    }

    @SuppressWarnings("unchecked")
    public List<Conditioner> getAllConditioners(){
        return entityManager.createNamedQuery("conditioner.getAll").getResultList();
    }
    public void deleteAllConditioners(){
        entityManager.createNamedQuery("conditioner.deleteAll").executeUpdate();
    }
    public Conditioner getConditionerByCapacity(double capacity){
        return (Conditioner) entityManager.createNamedQuery("conditioner.byCapacity").setParameter("capacity", capacity).getSingleResult();
    }
}