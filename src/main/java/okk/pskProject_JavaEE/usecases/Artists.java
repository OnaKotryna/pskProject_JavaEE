package okk.pskProject_JavaEE.usecases;

import lombok.Getter;
import lombok.Setter;
import okk.pskProject_JavaEE.entities.Artist;
import okk.pskProject_JavaEE.persistence.ArtistsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Artists {

    @Inject
    private ArtistsDAO artistsDAO;

    @Getter @Setter
    private Artist artistToCreate = new Artist();

    @Getter
    private List<Artist> allArtists;

    @PostConstruct
    public void init() { loadAllArtists(); }

    @Transactional
    public String createArtist(){
        this.artistsDAO.persist(artistToCreate);
        return "index?faces-redirect=true";
    }
    private void loadAllArtists() {
        this.allArtists = artistsDAO.loadAll();
    }
}
