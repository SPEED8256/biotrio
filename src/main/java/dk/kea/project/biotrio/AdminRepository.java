package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Admin;
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

public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Admin findAdmin(int id) {

        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM admin WHERE admin_id" + id);
        Admin admin = new Admin();
        while (rs.next()) {
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            admin.setName(rs.getString("name"));

        }
        return admin;
    }

    public List<Admin> findAllMovies() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM movie ");
        List<Admin> adminList = new ArrayList();
        while (rs.next()) {
            Admin admin = new Admin();
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            admin.setName(rs.getString("name"));

            adminList.add(admin);
        }
        return adminList;
    }

    public Admin insert(Admin admin) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "INSERT INTO admin VALUES(null , ?,?,?,)";
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                ps.setString(1, admin.getUsername());
                ps.setString(2, admin.getPassword());
                ps.setString(3, admin.getName());

                return ps;
            }
        };

        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        admin.setAdminId(id.getKey().intValue());
        return admin;
    }

    public void update(Admin admin) {
        String sql = "UPDATE admin SET username=?, password=?, name=?, WHERE adminId=" + admin.getAdminId();

        jdbc.update(sql, admin.getUsername(), admin.getPassword(), admin.getName());
    }

    public void delete(int id) {
        jdbc.update("DELETE FROM admin WHERE adminId = " + id);
    }


}


