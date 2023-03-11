package userservice.org.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AddressId")
    private Integer addressId;
    @Column(name="FlatAndApartment")
    private String flatAndApartment;
    @Column(name="Street")
    private String street;
    @Column(name="City")
    private String city;
    @Column(name="State")
    private String state;
    @Column(name="ZipCode")
    private long zipCode;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getFlatAndApartment() {
        return flatAndApartment;
    }

    public void setFlatAndApartment(String flatAndApartment) {
        this.flatAndApartment = flatAndApartment;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }
}
