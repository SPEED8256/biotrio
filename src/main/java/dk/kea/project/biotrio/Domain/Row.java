package dk.kea.project.biotrio.Domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Row {
    int id;
    Seat[] seats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[]  seats) {
        this.seats = seats;
    }

    public Row(int id, Seat[]  seats) {
        this.id = id;
        this.seats = seats;
    }
}
