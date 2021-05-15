package okk.pskProject_JavaEE.services;

import okk.pskProject_JavaEE.entities.Album;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class PriceGenerator implements Serializable {

    public double generatePrice(Album album){
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Double generatedPrice = album.getLength() / album.getSongNumber() * 6.31;
        return generatedPrice;
    }
}
