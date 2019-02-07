package pl.bskop.javaee.projekt.service;

import pl.bskop.javaee.projekt.domain.Conditioner;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ConditionerManager {

    @PersistenceContext
    EntityManager entityManager;
    @Inject
    ConditionerManager conditionerManager;
    @Inject
    ModelManager modelManager;
    @Inject
    ProducerManager producerManager;

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
    public List<Conditioner> getConditionerByCapacity(double capacity){
        return entityManager.createNamedQuery("conditioner.byCapacity").setParameter("capacity", capacity).getResultList();
    }
    public Conditioner getConditionerByModelName(String modelName){
        return  (Conditioner) entityManager.createNamedQuery("conditioner.byModelName").setParameter("name",modelName).getSingleResult();
    }
    public void addConditionerWithProducer(Conditioner conditioner,int prodID){

        conditioner.setProducer(producerManager.getProducer(prodID));
        entityManager.persist(conditioner);
    }
    public int addConditionerWithModel(Conditioner conditioner,int modelId){
        List<Conditioner> conditioners = conditionerManager.getAllConditioners();
int flag=0;
        for (Conditioner conditioner2: conditioners) {
            if (conditioner2.getModel().getId() == modelId){
               flag=1;
               return flag;

            }
        }


        conditioner.setModel(modelManager.getModel(modelId));
        entityManager.persist(conditioner);
        return flag;
    }
}
