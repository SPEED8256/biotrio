package dk.kea.project.biotrio.Domain;

import java.util.ArrayList;

public class Theater {
    int id;
    ArrayList<Row> rows;

    public Theater(int id, ArrayList <Row> rows) {
        this.id = id;
        this.rows = rows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList <Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList <Row> rows) {
        this.rows = rows;
    }
}
