package okk.pskProject_JavaEE.usecases;

import lombok.Getter;
import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.persistence.AlbumsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class DisplayAlbum {

    @Getter
    private Album album;

    @Inject
    private AlbumsDAO albumsDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumsDAO.findOne(albumId);
    }

}
