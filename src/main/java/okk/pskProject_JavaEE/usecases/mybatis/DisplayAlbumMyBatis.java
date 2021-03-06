package okk.pskProject_JavaEE.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.mybatis.dao.AlbumMapper;
import okk.pskProject_JavaEE.mybatis.dao.AlbumRecordMapper;
import okk.pskProject_JavaEE.mybatis.dao.RecordlabelMapper;
import okk.pskProject_JavaEE.mybatis.model.Album;
import okk.pskProject_JavaEE.mybatis.model.Artist;
import okk.pskProject_JavaEE.mybatis.model.Recordlabel;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class DisplayAlbumMyBatis {

    @Getter @Setter
    private Album album;

    @Inject
    private AlbumMapper albumMapper;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumMapper.selectByPrimaryKey(albumId);
    }

    @Transactional
    public List<Recordlabel> getLabels(){
        return albumMapper.selectByPrimaryKey(album.getId()).getRecordlabels();
    }

    public Artist getArtist(){
        return albumMapper.selectByPrimaryKey(album.getId()).getArtist();
    }

}
