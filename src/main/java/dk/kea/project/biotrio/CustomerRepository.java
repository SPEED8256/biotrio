package dk.kea.project.biotrio;

import dk.kea.project.biotrio.Domain.Customer;
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
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public Customer findCustomer(int id){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer WHERE customer_id = "+id);
        Customer customer = new Customer();
        while (rs.next()){
            customer.setId(rs.getInt("customer_id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getString("dob"));
            customer.setEmail(rs.getString("email"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            customer.setPaymentDetails(rs.getString("payment_details"));
        }
        return customer;
    }

    public List<Customer> findAllCustomers(){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer");
        List<Customer> customerList = new ArrayList<>();
        while (rs.next()){
            Customer customer = new Customer();
            customer.setId(rs.getInt("customer_id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getString("dob"));
            customer.setEmail(rs.getString("email"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            customer.setPaymentDetails(rs.getString("payment_details"));
            customerList.add(customer);
        }
        return customerList;
    }

    public Customer insert(Customer customer){

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES(null , ?,?,?,?,?,?,?)", new String[]{"id"});
                ps.setString(1, customer.getUsername());
                ps.setString(2, customer.getPassword());
                ps.setString(3, customer.getName());
                ps.setString(4, customer.getDob()); //????????????????????????????
                ps.setString(5, customer.getEmail());
                ps.setString(6, customer.getPhoneNumber());
                ps.setString(7, customer.getPaymentDetails());
                return ps;
            }
        };


        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        customer.setId(id.getKey().intValue());
        return customer;
    }


    public void delete(int id) {
        jdbc.update("DELETE FROM customer WHERE customer_id = "+id);
    }



    public void update(Customer customer) {
        String sql = "UPDATE customer SET username=?, password=?, name=?, dob=?, " +
                "email=?,phone_number=?, payment_details=? WHERE customer_id=" + customer.getId();

        jdbc.update(sql, customer.getUsername(), customer.getPassword(), customer.getName(), customer.getDob(),
                customer.getEmail(), customer.getPhoneNumber(), customer.getPaymentDetails());
    }
}


