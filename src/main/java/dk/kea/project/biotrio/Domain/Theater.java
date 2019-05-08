package dk.kea.project.biotrio.Domain;

import java.util.ArrayList;

public class Theater {
    int id;
    String name;
    ArrayList<Row> rows;
    int width;
    int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Theater(int id, ArrayList <Row> rows) {
        this.id = id;
        this.rows = rows;
    }

    public Theater(int id, String name, ArrayList <Row> rows) {
        this.id = id;
        this.name = name;
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
    public int getWidth(){
        return this.getRows().get(1).getSeats().length;
    }
    public int getHeight(){
        return this.getRows().size();
    }
}
