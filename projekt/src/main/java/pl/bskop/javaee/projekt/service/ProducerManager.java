package pl.bskop.javaee.projekt.service;

import pl.bskop.javaee.projekt.domain.Conditioner;
import pl.bskop.javaee.projekt.domain.Producer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProducerManager {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    ConditionerManager conditionerManager;

    public void addProducer(Producer producer) {
        entityManager.persist(producer);
    }

    public Producer getProducer(long id){
        return entityManager.find(Producer.class, id);
    }

    public Producer updateProducer(Producer transientProducer) {
        return entityManager.merge(transientProducer);
    }

    public void deleteProducer(long id){
        Producer producer = entityManager.find(Producer.class, id);

        List<Conditioner> conditioners = conditionerManager.getAllConditioners();

        for (Conditioner conditioner: conditioners) {
            if (conditioner.getProducer().getId() == producer.getId()){
                conditioner.setProducer(null);
            }
        }

        entityManager.remove(producer);
    }

    @SuppressWarnings("unchecked")
    public List<Producer> getAllProducers(){
        return entityManager.createNamedQuery("producer.getAll").getResultList();
    }
}
