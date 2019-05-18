package dk.kea.project.biotrio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginRepository {

    @Autowired
    private JdbcTemplate jdbc;

    //method goes through db customer table. Creates an object for each customer "username" and "password"
    //and adds the created objects to a list.
    //returns list

    public List<Customer> findAllCustomers() {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer");
        List<Customer> customerListUP = new ArrayList<>();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));

            customerListUP.add(customer);
        }
        return customerListUP;
    }
}











