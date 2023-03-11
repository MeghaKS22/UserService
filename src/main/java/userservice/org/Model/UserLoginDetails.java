package userservice.org.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.*;
@Repository
@Entity
@Table(name="UserLoginDetails")
public class UserLoginDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="LoginId")
    private Integer loginId;
    @Column(name="LastLogin")
    private Date lastLogin;
    @Column(name="AccountCreationDate")
    private Date accountCreationDate;
    @Column(name="AccountStatus")
    private char accountStatus;
    @Column(name="LoginStatus")
    private Boolean loginStatus;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public char getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(char accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
