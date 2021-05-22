package okk.pskProject_JavaEE.persistence.alternatives;

import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.persistence.AlbumsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
@Alternative
public class ShippingAlbumsDAO extends AlbumsDAO {

    @Inject
    EntityManager em;

    @Override
    public void persist(Album album) {
        double price = album.getPrice() + 5;
        album.setPrice(price);
        System.out.println("Alternative:\nNew price with added Shipping: " + price);
        this.em.persist(album);
    }
}
