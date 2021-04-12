package okk.pskProject_JavaEE.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Album {
    /**
     * This field corresponds to the database column PUBLIC.ALBUM.ID
     */
    private Integer id;

    /**
     * This field corresponds to the database column PUBLIC.ALBUM.LENGTH
     */
    private Integer length;

    /**
     * This field corresponds to the database column PUBLIC.ALBUM.SONG_NUMBER
     */
    private Integer songNumber;

    /**
     * This field corresponds to the database column PUBLIC.ALBUM.TITLE
     */
    private String title;

    /**
     * This field corresponds to the database column PUBLIC.ALBUM.ARTIST_ID
     */
    private Integer artistId;

    /**
     * This method returns the value of the database column PUBLIC.ALBUM.ID
     * @return the value of PUBLIC.ALBUM.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column PUBLIC.ALBUM.ID
     * @param id the value for PUBLIC.ALBUM.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column PUBLIC.ALBUM.LENGTH
     * @return the value of PUBLIC.ALBUM.LENGTH
     */
    public Integer getLength() {
        return length;
    }

    /**
     * This method sets the value of the database column PUBLIC.ALBUM.LENGTH
     * @param length the value for PUBLIC.ALBUM.LENGTH
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * This method returns the value of the database column PUBLIC.ALBUM.SONG_NUMBER
     * @return the value of PUBLIC.ALBUM.SONG_NUMBER
     */
    public Integer getSongNumber() {
        return songNumber;
    }

    /**
     * This method sets the value of the database column PUBLIC.ALBUM.SONG_NUMBER
     * @param songNumber the value for PUBLIC.ALBUM.SONG_NUMBER
     */
    public void setSongNumber(Integer songNumber) {
        this.songNumber = songNumber;
    }

    /**
     * This method returns the value of the database column PUBLIC.ALBUM.TITLE
     * @return the value of PUBLIC.ALBUM.TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets the value of the database column PUBLIC.ALBUM.TITLE
     * @param title the value for PUBLIC.ALBUM.TITLE
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns the value of the database column PUBLIC.ALBUM.ARTIST_ID
     * @return the value of PUBLIC.ALBUM.ARTIST_ID
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * This method sets the value of the database column PUBLIC.ALBUM.ARTIST_ID
     * @param artistId the value for PUBLIC.ALBUM.ARTIST_ID
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Getter @Setter
    private Artist artist;

    private List<Recordlabel> recordlabels = new ArrayList<>();
}