package hiber.graf.entity;


import java.io.Serializable;
import java.util.Objects;

public class ConnectionId implements Serializable {

    private City cityFrom;

    private City cityTo;

    public ConnectionId() {
    }

    public ConnectionId(City cityFrom, City cityTo) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectionId that = (ConnectionId) o;
        return cityFrom.equals(that.cityFrom) &&
                cityTo.equals(that.cityTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityFrom, cityTo);
    }
}
