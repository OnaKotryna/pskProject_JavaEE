package okk.pskProject_JavaEE.persistence;

import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.entities.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class AlbumsDAO {

    @Inject
    private EntityManager em;

    public void persist(Album album) {
        this.em.persist(album);
    }

    public Album findOne(Integer id) {
        return em.find(Album.class, id);
    }

    public Album update(Album album) {
        return em.merge(album);
    }

}
