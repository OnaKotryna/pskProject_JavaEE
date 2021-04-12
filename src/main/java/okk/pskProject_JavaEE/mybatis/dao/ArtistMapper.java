package okk.pskProject_JavaEE.mybatis.dao;

import okk.pskProject_JavaEE.mybatis.model.Album;
import okk.pskProject_JavaEE.mybatis.model.Artist;
import org.mybatis.cdi.Mapper;

import java.util.List;
@Mapper
public interface ArtistMapper {
    /**
     * This method corresponds to the database table PUBLIC.ARTIST
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table PUBLIC.ARTIST
     */
    int insert(Artist record);

    /**
     * This method corresponds to the database table PUBLIC.ARTIST
     */
    Artist selectByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table PUBLIC.ARTIST
     */
    List<Artist> selectAll();

    /**
     * This method corresponds to the database table PUBLIC.ARTIST
     */
    int updateByPrimaryKey(Artist record);

}