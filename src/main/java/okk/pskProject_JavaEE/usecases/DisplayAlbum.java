package okk.pskProject_JavaEE.usecases;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.entities.RecordLabel;
import okk.pskProject_JavaEE.persistence.AlbumsDAO;
import okk.pskProject_JavaEE.persistence.RecordLabelDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class DisplayAlbum {

    @Getter
    private Album album;

    @Inject
    private AlbumsDAO albumsDAO;

    @Inject
    private RecordLabelDAO labelDAO;

    @Getter @Setter
    private Integer labelIdToAdd;

    @Getter @Setter
    private String titleToChange;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumsDAO.findOne(albumId);
    }

    @Transactional
    public void addLabel(){
        RecordLabel labelToAdd = labelDAO.findOne(labelIdToAdd);
        this.album.getRecordLabels().add(labelToAdd);
        albumsDAO.update(this.album);
    }

    @Transactional
    public void changeTitle(){
        this.album.setTitle(titleToChange);
        albumsDAO.update(this.album);
    }
}
