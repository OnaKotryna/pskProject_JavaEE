package okk.pskProject_JavaEE.usecases;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.entities.Artist;
import okk.pskProject_JavaEE.persistence.AlbumsDAO;
import okk.pskProject_JavaEE.persistence.ArtistsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class AlbumsForArtist implements Serializable {

    @Inject
    private ArtistsDAO artistsDAO;

    @Inject
    private AlbumsDAO albumsDAO;

    @Getter @Setter
    private Artist artist;

    @Getter @Setter
    private Album albumToCreate = new Album();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer artistId = Integer.parseInt(requestParameters.get("artistId"));
        this.artist = artistsDAO.findOne(artistId);
    }

    @Transactional
    public String createAlbum() {
        albumToCreate.setArtist(this.artist);
        albumsDAO.persist(albumToCreate);
        return "artistsDetails?faces-redirect=true&artistId=" + this.artist.getId();
    }

}
