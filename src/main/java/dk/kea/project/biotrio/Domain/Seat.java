package dk.kea.project.biotrio.Domain;




public class Seat {
    int id;
    boolean status;

    public Seat() {
    }

    public Seat(int id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
