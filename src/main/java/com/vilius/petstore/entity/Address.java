package com.vilius.petstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Address")
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String Street;

    private String City;

//    private Locale locale;

    private Boolean shippingAddress;

    private Boolean billingAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setId() {
    }
}
