package okk.pskProject_JavaEE.persistence;

import okk.pskProject_JavaEE.entities.Album;

public interface IAlbumDAO {

    void persist(Album album);

    Album findOne(Integer id);

    Album update(Album album);
}
