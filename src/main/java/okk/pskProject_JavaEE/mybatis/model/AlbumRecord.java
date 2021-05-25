package okk.pskProject_JavaEE.mybatis.model;

public class AlbumRecord {
    /**
     * This field corresponds to the database column PUBLIC.ALBUM_RECORD.ALBUMS_ID
     */
    private Integer albumsId;

    /**
     * This field corresponds to the database column PUBLIC.ALBUM_RECORD.RECORDLABELS_ID
     */
    private Integer recordlabelsId;

    /**
     * This method returns the value of the database column PUBLIC.ALBUM_RECORD.ALBUMS_ID
     * @return the value of PUBLIC.ALBUM_RECORD.ALBUMS_ID
     */
    public Integer getAlbumsId() {
        return albumsId;
    }

    /**
     * This method sets the value of the database column PUBLIC.ALBUM_RECORD.ALBUMS_ID
     * @param albumsId the value for PUBLIC.ALBUM_RECORD.ALBUMS_ID
     */
    public void setAlbumsId(Integer albumsId) {
        this.albumsId = albumsId;
    }

    /**
     * This method returns the value of the database column PUBLIC.ALBUM_RECORD.RECORDLABELS_ID
     * @return the value of PUBLIC.ALBUM_RECORD.RECORDLABELS_ID
     */
    public Integer getRecordlabelsId() {
        return recordlabelsId;
    }

    /**
     * This method sets the value of the database column PUBLIC.ALBUM_RECORD.RECORDLABELS_ID
     * @param recordlabelsId the value for PUBLIC.ALBUM_RECORD.RECORDLABELS_ID
     */
    public void setRecordlabelsId(Integer recordlabelsId) {
        this.recordlabelsId = recordlabelsId;
    }

}