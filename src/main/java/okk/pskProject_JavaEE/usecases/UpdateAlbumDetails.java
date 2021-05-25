package okk.pskProject_JavaEE.usecases;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.interceptors.LoggedInvocation;
import okk.pskProject_JavaEE.persistence.AlbumsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateAlbumDetails implements Serializable {

    private Album album;

    @Inject
    private AlbumsDAO albumsDAO;

    @Getter @Setter
    private String titleToChange;

    @PostConstruct
    private void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumsDAO.findOne(albumId);
    }

    @Transactional
    @LoggedInvocation
    public String updateAlbumPrice() {
        try {
            albumsDAO.update(this.album);
        } catch (OptimisticLockException e) {
            return "/albumDetails.xhtml/?faces-redirect=true&albumId=" + this.album.getId() + "&error=optimistic-lock-exception";
        }
        return "/albumDetails.xhtml/albumId=" + this.album.getId() + "&faces-redirect=true";
    }

    @LoggedInvocation
    @Transactional
    public String updateAlbumTitle(){
        try{
            albumsDAO.update(this.album);
        } catch (OptimisticLockException e) {
            return "/albumDetails.xhtml/?faces-redirect=true&albumId=" + this.album.getId() + "&error=optimistic-lock-exception";
        }
        return "/albumDetails.xhtml/albumId=" + this.album.getId() + "&faces-redirect=true";
    }

}
