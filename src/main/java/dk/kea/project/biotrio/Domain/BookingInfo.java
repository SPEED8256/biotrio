package dk.kea.project.biotrio.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingInfo {

    @JsonProperty("customerId")
    private int customerId;


    @JsonProperty("screeningId")
    private int screeningId;

    @JsonProperty("tickets")
    private Ticket[] tickets;

    public BookingInfo() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }
}
