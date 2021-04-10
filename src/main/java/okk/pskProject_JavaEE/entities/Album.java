package okk.pskProject_JavaEE.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ALBUM")
@Getter @Setter
public class Album implements Serializable{

    public Album(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;

    @Column(name = "SONG_NUMBER")
    private Integer songNumber;

    @Column(name = "LENGTH")
    private Integer length;

    @ManyToMany
    @JoinTable(name = "ALBUM_RECORD")
    private List<RecordLabel> recordLabels = new ArrayList<>();

}
