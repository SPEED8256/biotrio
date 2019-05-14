package dk.kea.project.biotrio.Domain;

public class Theater{
    private int theaterId;
    private String theaterName;
    private int rows;
    private int seatsPerRow;


    //constructors

    public Theater (int theaterId, String theaterName, int rows, int seatsPerRow){
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public Theater(){
    }


    //getters and setters

    public int getId(){
        return theaterId;
    }

    public void setId(int theaterId){
        this.theaterId = theaterId;
    }

    public String getName(){
        return theaterName;
    }

    public void setName(String theaterName){
        this.theaterName = theaterName;
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

    @Override
    public String toString(){
        return "Theater{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", rows='" + rows + '\'' +
                ", seatsPerRow='" + seatsPerRow +
                "}";
    }
}