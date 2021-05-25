package okk.pskProject_JavaEE.mybatis.model;

import java.util.List;

public class Recordlabel {
    /**
     * This field corresponds to the database column PUBLIC.RECORDLABEL.ID
     */
    private Integer id;

    /**
     * This field corresponds to the database column PUBLIC.RECORDLABEL.COUNTRY
     */
    private String country;

    /**
     * This field corresponds to the database column PUBLIC.RECORDLABEL.LABEL
     */
    private String label;

    /**
     * This method returns the value of the database column PUBLIC.RECORDLABEL.ID
     * @return the value of PUBLIC.RECORDLABEL.ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column PUBLIC.RECORDLABEL.ID
     * @param id the value for PUBLIC.RECORDLABEL.ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column PUBLIC.RECORDLABEL.COUNTRY
     * @return the value of PUBLIC.RECORDLABEL.COUNTRY
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method sets the value of the database column PUBLIC.RECORDLABEL.COUNTRY
     * @param country the value for PUBLIC.RECORDLABEL.COUNTRY
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * This method returns the value of the database column PUBLIC.RECORDLABEL.LABEL
     * @return the value of PUBLIC.RECORDLABEL.LABEL
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method sets the value of the database column PUBLIC.RECORDLABEL.LABEL
     * @param label the value for PUBLIC.RECORDLABEL.LABEL
     */
    public void setLabel(String label) {
        this.label = label;
    }

    private List<Album> albums;
}