package dk.kea.project.biotrio.Domain;

public class Movie {

    private int movieId;
    private String movieTitle;
    private String movieGenre;
    private String movieYear;
    private String movieOrigin;
    private int movieDuration;
    private String movieDirector;
    private String movieActors;
    private double price;
    private String imdbCode;


    //constructors

    public Movie() {
    }

    public Movie(int movieId, String movieTitle, String movieGenre, String movieYear, String movieOrigin,
                 int movieDuration, String movieDirector, String movieActors, double price, String imdbCode) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
        this.movieOrigin = movieOrigin;
        this.movieDuration = movieDuration;
        this.movieDirector = movieDirector;
        this.movieActors = movieActors;
        this.price = price;
        this.imdbCode = imdbCode;
    }

    //getters and setters


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieOrigin() {
        return movieOrigin;
    }

    public void setMovieOrigin(String movieOrigin) {
        this.movieOrigin = movieOrigin;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImdbCode() {
        return imdbCode;
    }

    public void setImdbCode(String imdbCode) {
        this.imdbCode = imdbCode;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", movieYear='" + movieYear + '\'' +
                ", movieOrigin='" + movieOrigin + '\'' +
                ", movieDuration=" + movieDuration +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieActors='" + movieActors + '\'' +
                ", price=" + price +
                ", imdbCode='" + imdbCode + '\'' +
                '}';
    }
}
