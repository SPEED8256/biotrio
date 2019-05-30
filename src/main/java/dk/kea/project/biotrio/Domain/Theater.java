package dk.kea.project.biotrio.Domain;

import javax.persistence.*;
import java.util.List;

@Entity(name = "theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String theaterName;
    private int theaterRows;
    private int seatCount;


    public Theater() {
    }

    public Theater(int id, String theaterName, int rows, int seatCount) {
        this.id = id;
        this.theaterName = theaterName;
        this.theaterRows = rows;
        this.seatCount = seatCount;
    }

    public int getTheaterRows() {
        return theaterRows;
    }

    public void setTheaterRows(int theaterRows) {
        this.theaterRows = theaterRows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public int getRows() {
        return theaterRows;
    }

    public void setRows(int rows) {
        this.theaterRows = rows;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
}
