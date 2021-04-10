package okk.pskProject_JavaEE.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "RecordLabel.findAll", query = "select rl from RecordLabel as rl")
})
@Table(name = "RECORDLABEL")
@Getter @Setter
public class RecordLabel implements Serializable {

    public RecordLabel(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    @ManyToMany(mappedBy = "recordLabels")
    private List<Album> albums = new ArrayList<>();

}
