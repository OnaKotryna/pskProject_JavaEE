package okk.pskProject_JavaEE.services;

import okk.pskProject_JavaEE.entities.Album;

public interface IPriceGenerator {
    double generatePrice(Album album);
}
