package okk.pskProject_JavaEE.persistence;

import okk.pskProject_JavaEE.entities.Artist;

import java.util.List;

public interface IArtistDAO {

    List<Artist> loadAll();

    Artist findOne(Integer id);

    void persist(Artist artist);

    Artist update(Artist artist);
}
