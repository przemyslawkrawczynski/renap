package com.renap.service;

import com.renap.api.dto.ClientDto;
import com.renap.domain.client.Client;
import com.renap.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Set<ClientDto> findAllClients() {
        log.info("Find all clients");
        return clientRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toSet());
    }

    public void addClient(ClientDto dto) {
        log.info("Add client: {} {}", dto.getClientName(), dto.getClientSurname());
        var client = Client.builder()
                .withClientType(dto.getClientType())
                .withClientName(dto.getClientName())
                .withClientSurname(dto.getClientSurname())
                .withPhoneNumber(dto.getPhoneNumber())
                .withEmail(dto.getEmail())
                .withCity(dto.getCity())
                .withStreet(dto.getStreet())
                .withPostalCode(dto.getPostalCode())
                .withHomeNumber(dto.getPhoneNumber())
                .withFlatNumber(dto.getFlatNumber())
                .withNip(dto.getNip())
                .withPesel(dto.getPesel())
                .build();

        clientRepository.save(client);
    }

    private ClientDto mapToDto(Client client) {
        var dto = new ClientDto();
        dto.setId(client.getId());
        dto.setClientName(client.getClientName());
        dto.setClientSurname(client.getClientSurname());
        dto.setCity(client.getCity());
        dto.setStreet(client.getStreet());
        dto.setPhoneNumber(client.getPhoneNumber());
        return dto;
    }
}