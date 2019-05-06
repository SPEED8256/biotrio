package dk.kea.project.biotrio;

public class Theater{
    private int id;
    private String name;
    private int rows;
    private int seatsPerRow;

    public Theater (int id, String name, int rows, int seatsPerRow){
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public Theater(){
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public int getSeatsPerRow(){
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow){
        this.seatsPerRow = seatsPerRow;
    }
}