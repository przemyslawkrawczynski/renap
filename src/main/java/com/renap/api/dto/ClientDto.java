package com.renap.api.dto;

import com.renap.domain.client.ClientType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {

    private Long id;
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
}