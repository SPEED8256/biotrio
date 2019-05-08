package dk.kea.project.biotrio.Domain;

public class Seat {
    int id;
    boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Seat(int id) {
        this.id = id;
    }
    public Seat(int id, boolean status){
        this.id = id;
        this.status = status;
    }
}
