package okk.pskProject_JavaEE.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.mybatis.dao.AlbumMapper;
import okk.pskProject_JavaEE.mybatis.dao.ArtistMapper;
import okk.pskProject_JavaEE.mybatis.model.Album;
import okk.pskProject_JavaEE.mybatis.model.Artist;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class ArtistAlbumsMyBatis {

    @Inject
    private AlbumMapper albumMapper;

    @Inject
    private ArtistMapper artistMapper;

    @Getter @Setter
    private Artist artist;

    @Getter @Setter
    private Album albumToCreate = new Album();

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer artistId = Integer.parseInt(requestParameters.get("artistId"));
        this.artist = artistMapper.selectByPrimaryKey(artistId);
    }

    @Transactional
    public String createAlbum(){
        albumToCreate.setArtist(this.artist);
        albumToCreate.setArtistId(this.artist.getId());
        albumMapper.insert(albumToCreate);
        return "/mybatis/artistDetails?faces-redirect=true&artistId=" + this.artist.getId();
    }

    public List<Album> getAlbums(Integer id){
        return artistMapper.selectByPrimaryKey(artist.getId()).getAlbums();
    }

}
