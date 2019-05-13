package dk.kea.project.biotrio.Domain;

public class Seat {

    private int seatId;
    private String seatRow;
    private int seatNumber;
    private boolean seatStatus;

    //constructors

    public Seat(){}

    public Seat(int seatId, String seatRow, int seatNumber, boolean seatStatus) {
        this.seatId = seatId;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
    }

    //getters and setters


    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(boolean seatStatus) {
        this.seatStatus = seatStatus;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seatRow='" + seatRow + '\'' +
                ", seatNumber=" + seatNumber +
                ", seatStatus=" + seatStatus +
                '}';
    }
}

