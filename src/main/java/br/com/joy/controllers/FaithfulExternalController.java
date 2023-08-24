package br.com.joy.controllers;

import br.com.joy.entities.dtos.FaithfulDTO;
import br.com.joy.entities.formsobjects.FaithfulForm;
import br.com.joy.services.FaithfulService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/faithfulExternal")
@AllArgsConstructor
public class FaithfulExternalController {

    @Autowired
    private final FaithfulService faithfulService;

    @PostMapping
    public ResponseEntity<FaithfulDTO> createFaithful(@RequestBody() FaithfulForm faithfulForm, UriComponentsBuilder uriBuilder) {
        FaithfulDTO faithfulDTO = faithfulService.saveFaithful(new FaithfulDTO(faithfulForm));
        var uri = uriBuilder.path("/faithful/{id}").buildAndExpand(faithfulDTO.id()).toUri();
        return ResponseEntity.created(uri).body(faithfulDTO);
    }
}

