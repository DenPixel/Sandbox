package hiber.graf.entity;

import javax.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {

    @Id
    @ManyToOne()
    @JoinColumn(name = "from_id")
    private City from;

    @Id
    @ManyToOne()
    @JoinColumn(name = "to_id")
    private City to;

    @Id
    @Column(nullable = false)
    private Long cost;

    public Connection() {
    }

    public Connection(Long cost) {
        this.cost = cost;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void addConnection(City cityFrom, City cityTo){
       from = cityFrom;
       to = cityTo;
       cityFrom.getConnections().add(this);
       cityTo.getConnectionsOf().add(this);
    }
}
