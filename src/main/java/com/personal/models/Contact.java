package com.personal.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "contact")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @NotNull
    @Size(min = 10, max = 13, message = "Please enter a valid phone number")
    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "emailaddress")
    private String emailAddress;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adress> addresses = new ArrayList<>();

    @Override
    public String toString() {
        return "First name: " + getFirstName() + ", Last name: " + getLastName() + ", Phonenumber: " + getPhoneNumber() + ", Email: " + getEmailAddress();
    }

}
