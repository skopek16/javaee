package pl.bskop.javaee.projekt.service;

import pl.bskop.javaee.projekt.domain.Conditioner;
import pl.bskop.javaee.projekt.domain.Model;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ModelManager {
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    ConditionerManager conditionerManager;

    public void addModel(Model producer) {
        entityManager.persist(producer);
    }

    public Model getModel(int id){
        return entityManager.find(Model.class, id);
    }

    public Model updateModel(Model transientModel) {
        return entityManager.merge(transientModel);
    }
    public void deleteModel(int id){
        Model model = entityManager.find(Model.class, id);
        List<Conditioner> conditioners = conditionerManager.getAllConditioners();

        for (Conditioner conditioner: conditioners) {
            if (conditioner.getModel().getId() == model.getId()){
                conditioner.setModel(null);
            }
        }

        entityManager.remove(model);
    }


    @SuppressWarnings("unchecked")
    public List<Model> getAllModels(){
        return entityManager.createNamedQuery("model.getAll").getResultList();
    }
}
