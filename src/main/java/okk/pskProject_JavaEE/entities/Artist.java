package okk.pskProject_JavaEE.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Entity

/*@NamedQueries({
        @NamedQuery(name = "Artist.findAll", query = "select ar from Artist as ar")
})*/

@Table(name = "ARTIST")
@Getter @Setter
public class Artist {

    public Artist(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums = new ArrayList<>();

    public String Test(){
        return "Testas: artisto klase";
    }
}
