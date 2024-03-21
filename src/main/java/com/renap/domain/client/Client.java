package com.renap.domain.client;

import com.renap.domain.offer.Offer;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ClientType clientType;
    private String clientName;
    private String clientSurname;
    private String companyName;
    private String phoneNumber;
    private String email;
    private String city;
    private String street;
    private String postalCode;
    private String homeNumber;
    private String flatNumber;
    private String nip;
    private String pesel;
    @OneToMany(mappedBy = "client")
    private Set<Offer> offers;

}