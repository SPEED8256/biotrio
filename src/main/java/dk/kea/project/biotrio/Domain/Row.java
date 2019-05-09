package dk.kea.project.biotrio.Domain;



import java.lang.reflect.Array;
import java.util.ArrayList;

public class Row {
    int id;
    ArrayList<Seat> seats;

    public Row() {
    }

    public Row(int id, ArrayList <Seat> seats) {
        this.id = id;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList <Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList <Seat> seats) {
        this.seats = seats;
    }
}
