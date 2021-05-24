package okk.pskProject_JavaEE.persistence.alternatives;

import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.persistence.IAlbumDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;


@ApplicationScoped
@Specializes
@Alternative
public class DutyAlbumsDAO extends VATAlbumsDAO implements IAlbumDAO {

    @Inject
    EntityManager em;

    @Override
    public void persist(Album album) {
        double price = album.getPrice() + 2.50;
        album.setPrice(price);
        System.out.println("Alternative\nNew price with added duty: " + price);
        this.em.persist(album);
    }

}
