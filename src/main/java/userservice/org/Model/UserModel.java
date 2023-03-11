package userservice.org.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Repository
@Entity
@Table(name = "user_details")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private Integer userId;
    @Column(name="Name")
    private String name;
    @Column(name="Email_Id", nullable = false)
    private String email;
    @Column(name="Password")
    private String passwordHash;

    @Column(name="PhoneNumber")
    private long phoneNumber;
    @Column(name="DateOfBirth")
    private LocalDate dob;
    @Column(name="Gender")
    private char gender;
    @Column(name="AllowedPermissions")
    private ArrayList<String> permissions = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ULD", referencedColumnName = "loginId")
    private UserLoginDetails userLoginDetails;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Address",referencedColumnName = "addressId")
    private Address address;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }
    public void setDOB(LocalDate dob) { this.dob = dob;}

    public char getGender() {
        return gender;
    }

    public void setGender(char g) {
        this.gender = g;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<String> permissions) {
        this.permissions = permissions;
    }

    public UserLoginDetails getUserLoginDetails() {
        return userLoginDetails;
    }

    public void setUserLoginDetails(UserLoginDetails userLoginDetails) {
        this.userLoginDetails = userLoginDetails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
