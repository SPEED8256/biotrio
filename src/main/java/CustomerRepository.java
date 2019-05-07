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
import java.util.Date;
import java.util.List;
import java.time.LocalDate;


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
            customer.setDob(rs.getDate("date_of_birth"));
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
            customer.setId(rs.getInt("id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setDob(rs.getDate("date_of_birth"));
            customer.setEmail(rs.getString("email "));
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
                ps.setDate(3, (java.sql.Date) customer.getDob()); //????????????????????????????
                ps.setString(4, customer.getEmail());
                ps.setString(4, customer.getPhoneNumber());
                ps.setString(4, customer.getPaymentDetails());
                return ps;
            }
        };

//        String sql = "INSERT INTO cars VALUES(NULL, '"+car.getReg()+"', '"+car.getBrand()+"', '"+car.getColor()+"', "+car.getMaxSpeed()+")";
//        jdbc.execute(sql);
//        jdbc.execute("SELECT last_insert_id() FROM cars");


        KeyHolder id = new GeneratedKeyHolder();
        jdbc.update(psc, id);
        customer.setId(id.getKey().intValue());
        return customer;
    }


    public void delete(int id) {
        jdbc.update("DELETE FROM customer WHERE id = "+id);
    }
}

