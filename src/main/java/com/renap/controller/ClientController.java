package com.renap.controller;

import com.renap.api.dto.ClientDto;
import com.renap.domain.client.ClientType;
import com.renap.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String findAllClients(Model model) {
        model.addAttribute("clients", clientService.findAllClients());
        return "clients/clients";
    }

    @GetMapping("/add")
    public String addClient(Model model) {
        model.addAttribute("types", ClientType.values());
        model.addAttribute("client", new ClientDto());
        return "clients/addclient";
    }

    @PostMapping
    public String addClient(@ModelAttribute ClientDto client) {
        clientService.addClient(client);
        return "redirect:/clients";
    }
}