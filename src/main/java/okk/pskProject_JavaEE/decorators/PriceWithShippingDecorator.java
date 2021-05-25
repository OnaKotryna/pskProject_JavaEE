package okk.pskProject_JavaEE.decorators;

import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.services.IPriceGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class PriceWithShippingDecorator implements IPriceGenerator {

    @Inject @Delegate @Any IPriceGenerator priceGenerator;

    @Override
    public double generatePrice(Album album){
        try {
            double price = priceGenerator.generatePrice(album);
            Thread.sleep(5000);
            System.out.println("Price before Fixed Shipping:" + price);
            System.out.println("Added Fixed Shipping to generated price");
            double shippedPrice = price + 3;
            System.out.println("Price after  Fixed Shipping:" + shippedPrice);
            return shippedPrice;
        } catch (InterruptedException ie) {
            return 0;
        }
    }

}
