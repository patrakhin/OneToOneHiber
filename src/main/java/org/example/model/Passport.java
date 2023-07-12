package org.example.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Passport")
public class Passport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person_OtO person_otO;

    @Column(name = "passport_number")
    private int passportNumber;

    public Passport(){}

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person_OtO getPerson_otO() {
        return person_otO;
    }

    public void setPerson_otO(Person_OtO person_otO) {
        this.person_otO = person_otO;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "person_otO=" + person_otO +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
