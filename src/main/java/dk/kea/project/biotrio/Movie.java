package dk.kea.project.biotrio;

public class Movie {

    private int movie_id;
    private String movie_title;
    private String movie_genre;
    private String movie_year;
    private String movie_origin;
    private int movie_duration;
    private String movie_director;
    private String movie_actor;
    private double price;

    //constructors

    public Movie() {
    }

    public Movie(int movie_id, String movie_title, String movie_genre, String movie_year,
                 String movie_origin, int movie_duration, String movie_director,
                 String movie_actor, double price) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_genre = movie_genre;
        this.movie_year = movie_year;
        this.movie_origin = movie_origin;
        this.movie_duration = movie_duration;
        this.movie_director = movie_director;
        this.movie_actor = movie_actor;
        this.price = price;
    }

    //getters and setters

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public String getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(String movie_year) {
        this.movie_year = movie_year;
    }

    public String getMovie_origin() {
        return movie_origin;
    }

    public void setMovie_origin(String movie_origin) {
        this.movie_origin = movie_origin;
    }

    public int getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(int movie_duration) {
        this.movie_duration = movie_duration;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_actor() {
        return movie_actor;
    }

    public void setMovie_actor(String movie_actor) {
        this.movie_actor = movie_actor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_title='" + movie_title + '\'' +
                ", movie_genre='" + movie_genre + '\'' +
                ", movie_year='" + movie_year + '\'' +
                ", movie_origin='" + movie_origin + '\'' +
                ", movie_duration=" + movie_duration +
                ", movie_director='" + movie_director + '\'' +
                ", movie_actor='" + movie_actor + '\'' +
                ", price=" + price +
                '}';
    }


}
