package pl.bskop.javaee.projekt.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQuery(name = "producer.getAll", query = "Select p from Producer p")
public class Producer {

    private long id;
    private String name;

    public Producer(String name) {
        this.name = name;
    }

    public Producer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
