package systems.ab4.workshop.spots;

import javax.persistence.*;

/**
 * Created by Marina on 22.06.2017.
 */


@Entity
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private Location location;

    public Spot(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
