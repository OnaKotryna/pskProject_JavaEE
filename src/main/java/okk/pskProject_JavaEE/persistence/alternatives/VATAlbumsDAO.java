package okk.pskProject_JavaEE.persistence.alternatives;

import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.persistence.AlbumsDAO;
import okk.pskProject_JavaEE.persistence.IAlbumDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.ApplicationPath;

@ApplicationScoped
@Alternative
public class VATAlbumsDAO extends AlbumsDAO implements IAlbumDAO {

    @Inject
    EntityManager em;

    @Override
    public void persist(Album album) {
        double price = album.getPrice() + album.getPrice() * 0.21;
        album.setPrice(price);
        System.out.println("Alternative\nNew price with added VAT: " + price);
        this.em.persist(album);
    }
}
