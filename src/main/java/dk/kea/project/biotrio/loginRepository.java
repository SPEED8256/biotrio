package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Customer;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class loginRepository {


    @Autowired
    private JdbcTemplate jdbc;


    public Customer findCustomerUsernamePassword(int id){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer WHERE  username = ? and password = ?");
        Customer customer = new Customer();
        while (rs.next()){
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
        }
        return customer;
    }

    public List<Customer> findAllCustomersUsernamePassword(){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer");
        List<Customer> customerListUP = new ArrayList<>();
        while (rs.next()){
            Customer customer = new Customer();
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
        }
        return customerListUP;
    }
}
