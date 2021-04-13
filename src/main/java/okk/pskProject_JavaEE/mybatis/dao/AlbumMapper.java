package okk.pskProject_JavaEE.mybatis.dao;

import okk.pskProject_JavaEE.mybatis.model.Album;
import okk.pskProject_JavaEE.mybatis.model.Recordlabel;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface AlbumMapper {
    /**
     * This method corresponds to the database table PUBLIC.ALBUM
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table PUBLIC.ALBUM
     */
    int insert(Album record);

    /**
     * This method corresponds to the database table PUBLIC.ALBUM
     */
    Album selectByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table PUBLIC.ALBUM
     */
    List<Album> selectAll();

    /**
     * This method corresponds to the database table PUBLIC.ALBUM
     */
    int updateByPrimaryKey(Album record);

}