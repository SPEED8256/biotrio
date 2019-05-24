package dk.kea.project.biotrio.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty("place")
    int ticketseat;

    @JsonProperty("row")
    int ticketRow;

    boolean ticketStatus;

    public boolean isTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }


    public Ticket() {
    }

    public boolean isStatus() {
        return ticketStatus;
    }

    public int getTicketseat() {
        return ticketseat;
    }

    public void setTicketseat(int ticketseat) {
        this.ticketseat = ticketseat;
    }

    public int getTicketRow() {
        return ticketRow;
    }

    public void setTicketRow(int ticketRow) {
        this.ticketRow = ticketRow;
    }

    public void setStatus(boolean status) {
        this.ticketStatus = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
