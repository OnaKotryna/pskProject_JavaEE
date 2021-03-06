package okk.pskProject_JavaEE.persistence;

import okk.pskProject_JavaEE.entities.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ArtistsDAO implements IArtistDAO {

    @Inject
    private EntityManager em;

    public List<Artist> loadAll() {
        return em.createNamedQuery("Artist.findAll", Artist.class).getResultList();
    }

    public Artist findOne(Integer id) {
        return em.find(Artist.class, id);
    }

    public void persist(Artist artist) {
        this.em.persist(artist);
    }

    public Artist update(Artist artist) {
        return em.merge(artist);
    }

}
