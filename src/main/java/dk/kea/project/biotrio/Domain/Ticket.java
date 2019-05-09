package dk.kea.project.biotrio.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Ticket {
    int id;
    @JsonProperty("place")
    int seat;
    @JsonProperty("row")
    int row;

    public Ticket(int id, int seat, int row) {
        this.id = id;
        this.seat = seat;
        this.row = row;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
