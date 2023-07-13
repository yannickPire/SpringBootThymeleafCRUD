package com.personal.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "adres")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "street")
    private String street;

    @NonNull
    @Column(name = "number")
    private String number;

    @NonNull
    @Column(name = "zip_code")
    private String zipcode;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "country")
    private String country;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

}
