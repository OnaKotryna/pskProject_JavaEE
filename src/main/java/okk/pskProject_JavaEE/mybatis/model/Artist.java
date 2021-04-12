package okk.pskProject_JavaEE.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    /**
     * This field corresponds to the database column PUBLIC.ARTIST.ID
     */
    private Integer id;

    /**
     * This field corresponds to the database column PUBLIC.ARTIST.COUNTRY
     */
    private String country;

    /**
     * This field corresponds to the database column PUBLIC.ARTIST.NAME
     */
    private String name;

    /**
     * This method returns the value of the database column PUBLIC.ARTIST.ID
     * @return the value of PUBLIC.ARTIST.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column PUBLIC.ARTIST.ID
     * @param id the value for PUBLIC.ARTIST.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column PUBLIC.ARTIST.COUNTRY
     * @return the value of PUBLIC.ARTIST.COUNTRY
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method sets the value of the database column PUBLIC.ARTIST.COUNTRY
     * @param country the value for PUBLIC.ARTIST.COUNTRY
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * This method returns the value of the database column PUBLIC.ARTIST.NAME
     * @return the value of PUBLIC.ARTIST.NAME
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the value of the database column PUBLIC.ARTIST.NAME
     * @param name the value for PUBLIC.ARTIST.NAME
     */
    public void setName(String name) {
        this.name = name;
    }


    private List<Album> albums = new ArrayList<>();
}