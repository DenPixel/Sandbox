package hiber.graf.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "connections")
public class Connection implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "from_id")
    private City cityFrom;

    @Id
    @ManyToOne
    @JoinColumn(name = "to_id")
    private City cityTo;

    @Column(nullable = false)
    private Integer cost;

    public Connection() {
    }

    public Connection(City cityFrom, City cityTo, Integer cost) {
        addConnection(cityFrom, cityTo, cost);
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void addConnection(City cityFrom, City cityTo){
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        cityFrom.getConnections().add(this);
        cityTo.getConnectionsOf().add(this);
        
    }

    public void addConnection(City cityFrom, City cityTo, Integer cost){
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        cityFrom.getConnections().add(this);
        cityTo.getConnectionsOf().add(this);
        this.cost = cost;
    }
}
