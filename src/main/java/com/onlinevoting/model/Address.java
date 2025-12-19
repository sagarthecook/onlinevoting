package com.onlinevoting.model;

<<<<<<< HEAD
import jakarta.persistence.Column;
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< HEAD
=======
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
<<<<<<< HEAD
public class Address extends AuditDetail {
=======
public class Address {
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City cityId; // 1-1

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State stateId; // 1-1

<<<<<<< HEAD
    @Column(name = "zip_code", nullable = false)
=======
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
    private String zipCode; // 1-1

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country countryId; // 1-1

<<<<<<< HEAD
    public Address(String street, City cityId, State stateId, String zipCode, Country countryId) {
        super();
=======
    private Boolean isActive;

    public Address(Long id) {
        this.id = id;
    }
    
    public Address(String street, City cityId, State stateId, String zipCode, Country countryId, Boolean isActive) {
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
        this.street = street;
        this.cityId = cityId;
        this.stateId = stateId;
        this.zipCode = zipCode;
        this.countryId = countryId;
<<<<<<< HEAD
    }

    public Address() {
=======
        this.isActive = isActive;
    }

    public Address() {

    }

    @PrePersist
    public void prePersist() {
        if (isActive == null) {
            isActive = true; // Default value
        }
>>>>>>> 54e1742399e6bb5a80a1a317934d2ca560f223fc
    }
}
