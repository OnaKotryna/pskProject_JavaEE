package okk.pskProject_JavaEE.persistence;

import okk.pskProject_JavaEE.entities.RecordLabel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class RecordLabelDAO {

    @Inject
    private EntityManager em;

    public List<RecordLabel> loadAll(){
        return em.createNamedQuery("RecordLabel.findAll", RecordLabel.class).getResultList();
    }

    public void persist(RecordLabel recordLabel){
        this.em.persist(recordLabel);
    }

    public RecordLabel findOne(Integer id){
        return em.find(RecordLabel.class, id);
    }

}
