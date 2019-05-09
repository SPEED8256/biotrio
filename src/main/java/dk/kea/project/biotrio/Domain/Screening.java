package dk.kea.project.biotrio.Domain;



import java.time.LocalDateTime;

public  class Screening {
    int id;
    LocalDateTime screeningDateTime;
    int price;
    Movie movie;
    Theater theater;

    public Screening() {
    }

    public Screening(int id, LocalDateTime screeningDateTime, int price, Movie movie, Theater theater) {
        this.id = id;
        this.screeningDateTime = screeningDateTime;
        this.price = price;
        this.movie = movie;
        this.theater = theater;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getScreeningDateTime() {
        return screeningDateTime;
    }

    public void setScreeningDateTime(LocalDateTime screeningDateTime) {
        this.screeningDateTime = screeningDateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
