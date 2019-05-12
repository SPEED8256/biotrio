package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Movie findMovie(int id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie WHERE movie_id" + id);
        Movie movie = new Movie();
        while (rs.next()) {
            movie.setMovieId(rs.getInt("movieId"));
            movie.setMovieTitle(rs.getString("movieTitle"));
            movie.setMovieGenre(rs.getString("movieGenre"));
            movie.setMovieYear(rs.getString("movieYear"));
            movie.setMovieOrigin(rs.getString("movieOrigin"));
            movie.setMovieDuration(rs.getInt("movieDuration"));
            movie.setMovieDirector(rs.getString("movieDirector"));
            movie.setMovieActor(rs.getString("movieActors"));
            movie.setPrice(rs.getDouble("price"));
            movie.setImdbCode(rs.getString("imdbCode"));
        }
        return movie;
    }

    public List<Movie> findAllMovies() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie ");
        List<Movie> movieList = new ArrayList();
        while (rs.next()) {
            Movie movie = new Movie();
            movie.setMovieId(rs.getInt("movieId"));
            movie.setMovieTitle(rs.getString("movieTitle"));
            movie.setMovieGenre(rs.getString("movieGenre"));
            movie.setMovieYear(rs.getString("movieYear"));
            movie.setMovieOrigin(rs.getString("movieOrigin"));
            movie.setMovieDuration(rs.getInt("movieDuration"));
            movie.setMovieDirector(rs.getString("movieDirector"));
            movie.setMovieActor(rs.getString("movieActors"));
            movie.setPrice(rs.getDouble("price"));
            movie.setImdbCode(rs.getString("imdbCode"));


            movieList.add(movie);
        }
        return movieList;
    }

    public Movie insert(Movie movie) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO movie VALUES(null , ?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, movie.getMovieTitle());
                ps.setString(2, movie.getMovieGenre());
                ps.setString(3, movie.getMovieYear());
                ps.setString(4, movie.getMovieOrigin());
                ps.setInt(5, movie.getMovieDuration());
                ps.setString(6, movie.getMovieDirector());
                ps.setString(7, movie.getMovieActor());
                ps.setString(8, movie.getImdbCode());
                ps.setDouble(9, movie.getPrice());

                return ps;
            }
        };

        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        movie.setMovieId(id.getKey().intValue());
        return movie;
    }

    public void update(Movie movie) {
        String sql = "UPDATE movie SET movieTitle=?, movie_Genre=?, movieYear=?, movieOrigin=?, movieDureation=?, " +
                "movieDirector=?," + " movieActors=?, price=?, imdbCode=?, WHERE movieId=" + movie.getMovieId();

        jdbc.update(sql, movie.getMovieTitle(), movie.getMovieGenre(), movie.getMovieYear(), movie.getMovieOrigin(),
                movie.getMovieDuration(), movie.getMovieDirector(), movie.getMovieActor(), movie.getImdbCode(),
                movie.getPrice());
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM movie WHERE movie_id = " + id);
    }


}
