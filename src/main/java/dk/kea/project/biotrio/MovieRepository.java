package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Movie findMovie(int id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie WHERE movie_id=" + id);
        Movie movie = new Movie();
        while (rs.next()) {
            movie.setMovieId(rs.getInt("movie_id"));
            movie.setMovieTitle(rs.getString("movie_title"));
            movie.setMovieGenre(rs.getString("movie_genre"));
            movie.setMovieYear(rs.getInt("movie_year"));
            movie.setMovieOrigin(rs.getString("movie_origin"));
            movie.setMovieDuration(rs.getInt("movie_duration"));
            movie.setMovieDirector(rs.getString("movie_director"));
            movie.setMovieActors(rs.getString("movie_actors"));
            movie.setPrice(rs.getDouble("price"));
            movie.setImdbCode(rs.getString("imdb_id"));
        }
        return movie;
    }

    public List<Movie> findAllMovies() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie ");
        List<Movie> movieList = new ArrayList();
        while (rs.next()) {
            Movie movie = new Movie();
            movie.setMovieId(rs.getInt("movie_id"));
            movie.setMovieTitle(rs.getString("movie_title"));
            movie.setMovieGenre(rs.getString("movie_genre"));
            movie.setMovieYear(rs.getInt("movie_year"));
            movie.setMovieOrigin(rs.getString("movie_origin"));
            movie.setMovieDuration(rs.getInt("movie_duration"));
            movie.setMovieDirector(rs.getString("movie_director"));
            movie.setMovieActors(rs.getString("movie_actors"));
            movie.setPrice(rs.getDouble("price"));
            movie.setImdbCode(rs.getString("imdb_id"));

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
                ps.setInt(3, movie.getMovieYear());
                ps.setString(4, movie.getMovieOrigin());
                ps.setInt(5, movie.getMovieDuration());
                ps.setString(6, movie.getMovieDirector());
                ps.setString(7, movie.getMovieActors());
                ps.setDouble(9, movie.getPrice());
                ps.setString(8, movie.getImdbCode());

                return ps;
            }
        };

        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        movie.setMovieId(id.getKey().intValue());
        return movie;
    }

    public void update(Movie movie) {
        String sql = "UPDATE movie SET movie_title=?, movie_genre=?, movie_year=?, movie_origin=?, movie_duration=?, " +
                "movie_director=?," + " movie_actors=?, price=?, imdb_id=? WHERE movie_id=" + movie.getMovieId();

        jdbc.update(sql, movie.getMovieTitle(), movie.getMovieGenre(), movie.getMovieYear(), movie.getMovieOrigin(),
                movie.getMovieDuration(), movie.getMovieDirector(), movie.getMovieActors(),  movie.getPrice(),
                movie.getImdbCode());
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM movie WHERE movie_id =" + id);
    }


}
