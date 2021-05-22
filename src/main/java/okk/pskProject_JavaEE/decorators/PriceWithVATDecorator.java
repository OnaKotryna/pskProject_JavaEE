package okk.pskProject_JavaEE.decorators;

import okk.pskProject_JavaEE.entities.Album;
import okk.pskProject_JavaEE.interceptors.LoggedInvocation;
import okk.pskProject_JavaEE.services.IPriceGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.sql.SQLOutput;

@Decorator
public abstract class PriceWithVATDecorator implements IPriceGenerator {

    @Inject @Delegate @Any IPriceGenerator priceGenerator;

    @Override
    public double generatePrice(Album album){
        try {
            double price = priceGenerator.generatePrice(album);
            Thread.sleep(5000);
            System.out.println("Price before tax:" + price);
            System.out.println("Added VAT to generated price");
            double taxedPrice = price + price * 0.21;
            System.out.println("Price after tax:" + taxedPrice);
            return taxedPrice;
        } catch (InterruptedException ie) {
            return 0;
        }
    }
}
