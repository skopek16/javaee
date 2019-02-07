package pl.bskop.javaee.projekt.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement

@NamedQueries({
        @NamedQuery(name = "conditioner.getAll", query = "Select c from Conditioner c"),
        @NamedQuery(name = "conditioner.deleteAll", query = "Delete  from Conditioner"),
        @NamedQuery(name = "conditioner.byCapacity", query = "Select c from Conditioner c where c.capacity = :capacity"),
})
public class Conditioner {

    private long id;
    private Model model;
    private Date produceDate;
    private double capacity;
    private int fans;

    private Producer producer;

    public Conditioner( Date produceDate, double capacity, int fans) {

        this.produceDate = produceDate;
        this.capacity = capacity;
        this.fans = fans;
    }

    public Conditioner() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @Temporal(TemporalType.DATE)
    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
