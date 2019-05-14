package dk.kea.project.biotrio;

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
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer WHERE id = "+id);
        Customer customer = new Customer();
        while (rs.next()){
            customer.setId(rs.getInt("id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getDate("dob"));
            customer.setEmail(rs.getString("email"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            customer.setPaymentDetails(rs.getString("payment_details"));
        }
        return customer;
    }

    public List<Customer> findAllCustomers(){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM customer");
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer();
        while (rs.next()){
            customer.setId(rs.getInt("customer_id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getDate("dob"));
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
                ps.setDate(4, (java.sql.Date) customer.getDob()); //????????????????????????????
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
        jdbc.update("DELETE FROM customer WHERE id = "+id);
    }

    public void update(Customer customer) {
        jdbc.update("UPDATE customer SET " +
                "username='" + customer.getUsername() + "', " +
                "password='" + customer.getPassword() + "', " +
                "name='" + customer.getName() + "', " +
                "date of bith=" + customer.getDob() + "' " +
                "email='" + customer.getEmail() + "', " +
                "phone number='" + customer.getPhoneNumber() + "', " +
                "Payment details='" + customer.getPaymentDetails() + "' " +
                "WHERE id=" + customer.getId());
    }
}


