package dk.kea.project.biotrio.Domain;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Customer {
    private int id;
    private String username;
    private String password;
    private String name;
    private LocalDate dob;
    private String email;
    private String phoneNumber;
    private String paymentDetails;


    public Customer() {
    }

    public Customer(int id, String username, String password, String name, LocalDate dob, String email,
                    String phoneNumber, String paymentDetails) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.paymentDetails = paymentDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "dk.kea.project.biotrio.Domain.Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                '}';
    }

    public static class Admin {

        private String adminId;
        private String username;
        private String password;
        private String name;

        //constructors

        public Admin() {
        }

        public Admin(String adminId, String username, String password, String name) {
            this.adminId = adminId;
            this.username = username;
            this.password = password;
            this.name = name;
        }

        public String getAdminId() {
            return adminId;
        }

        public void setAdminId(String adminId) {
            this.adminId = adminId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Admin{" +
                    "adminId='" + adminId + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Screening {

        private int screeningIid;
        private LocalDateTime screeningDateTime;

        //constructors

        public Screening(int screeningIid, LocalDateTime screeningDateTime) {
            this.screeningIid = screeningIid;
            this.screeningDateTime = screeningDateTime;
        }

        //getters and setters
        public int getScreeningIid() {
            return screeningIid;
        }

        public void setScreeningIid(int screeningIid) {
            this.screeningIid = screeningIid;
        }

        public LocalDateTime getScreeningDateTime() {
            return screeningDateTime;
        }

        public void setScreeningDateTime(LocalDateTime screeningDateTime) {
            this.screeningDateTime = screeningDateTime;
        }

        @Override
        public String toString() {
            return "Screening{" +
                    "screeningIid=" + screeningIid +
                    ", screeningDateTime=" + screeningDateTime +
                    '}';
        }
    }
}
