package dk.kea.project.biotrio.Domain;

import javax.persistence.*;


@Entity(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieTitle;
    private String imdbCode;
    private String movieGenre;
    private String movieYear;
    private String movieOrigin;
    private int movieDuration;
    private String movieDirector;
    private String movieActor;
    private String imagePathName;
    private boolean spotlight;
    private boolean upcoming;


    public Movie() {
    }

    public boolean isUpcoming() {
        return upcoming;
    }

    public void setUpcoming(boolean upcoming) {
        this.upcoming = upcoming;
    }

    public boolean isSpotlight() {
        return spotlight;
    }

    public void setSpotlight(boolean spotlight) {
        this.spotlight = spotlight;
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

    public String getImdbCode() {
        return imdbCode;
    }

    public void setImdbCode(String imdbCode) {
        this.imdbCode = imdbCode;
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

    public String getImagePathName() {
        return imagePathName;
    }

    public void setImagePathName(String imagePathName) {
        this.imagePathName = imagePathName;
    }



}

