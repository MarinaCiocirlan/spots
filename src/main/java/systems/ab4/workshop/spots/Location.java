package systems.ab4.workshop.spots;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Marina on 22.06.2017.
 */
@Entity

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private Location parent;

    public Location(){

    }

    public Location(Long id, Location parent) {
        this.id = id;
        this.parent = parent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
