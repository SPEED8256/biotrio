package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Customer;
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

    public List<Customer> findCustomerUsernamePassword() {

        String sql = "SELECT  customer_id * FROM customer WHERE  username = ? and password = ?";

        try {
            SqlRowSet rs = jdbc.queryForRowSet(sql);
            List<Customer> customerListUP = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));

                customerListUP.add(customer);
            }
            return customerListUP;

        } catch (Exception e) {
            return null;
        }

    }


}











