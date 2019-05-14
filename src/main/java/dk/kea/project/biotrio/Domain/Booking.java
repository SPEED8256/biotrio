package dk.kea.project.biotrio.Domain;

public class Booking {

    private int bookingId;
    private int customerId;
    private int movieId;
    private int theaterId;
    private int screeningId;
    private int seatId;

    //constructors

    public Booking(){}

    public Booking(int bookingId, int customerId, int movieId, int theaterId, int screeningId, int seatId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.screeningId = screeningId;
        this.seatId = seatId;
    }

    //getters and setters


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) { this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", movieId=" + movieId +
                ", theaterId=" + theaterId +
                ", screeningId=" + screeningId +
                ", seatId=" + seatId +
                '}';
    }
}
