package dk.kea.project.biotrio.Domain;

public class Movie {

    private int movieId;
    private String movieTitle;
    private String imdbCode;
    private String movieGenre;
    private String movieYear;
    private String movieOrigin;
    private int movieDuration;
    private String movieDirector;
    private String movieActor;
    private int price;


    //constructors

    public Movie() {
    }

    public Movie(int movieId, String movieTitle, String imdbCode, String movieGenre, String movieYear,
                 String movieOrigin, int movie_duration, String movieDirector,
                 String movieActor, int price) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.imdbCode = imdbCode;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
        this.movieOrigin = movieOrigin;
        this.movieDuration = movie_duration;
        this.movieDirector = movieDirector;
        this.movieActor = movieActor;
        this.price = price;
    }

    //getters and setters


    public String getImdbCode() {
        return imdbCode;
    }

    public void setImdbCode(String imdbCode) {
        this.imdbCode = imdbCode;
    }

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

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
                ", movieActor='" + movieActor + '\'' +
                ", price=" + price +
                '}';
    }


}
