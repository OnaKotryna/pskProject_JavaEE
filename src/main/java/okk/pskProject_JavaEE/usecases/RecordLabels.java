package okk.pskProject_JavaEE.usecases;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.entities.RecordLabel;
import okk.pskProject_JavaEE.interceptors.LoggedInvocation;
import okk.pskProject_JavaEE.persistence.RecordLabelDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class RecordLabels {

    @Inject
    private RecordLabelDAO labelDAO;

    @Getter @Setter
    private RecordLabel labelToCreate = new RecordLabel();

    @Getter
    private List<RecordLabel> allLabels;

    @PostConstruct
    public void init(){
        loadAllLabels();
    }

    @Transactional
    @LoggedInvocation
    public String createLabel(){
        this.labelDAO.persist(labelToCreate);
        return "labels?faces-redirect=true";
    }

    private void loadAllLabels(){
        this.allLabels = labelDAO.loadAll();
    }

}
