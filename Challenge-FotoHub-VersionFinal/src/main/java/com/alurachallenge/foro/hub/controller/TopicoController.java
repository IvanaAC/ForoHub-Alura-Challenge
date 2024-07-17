package com.alurachallenge.foro.hub.controller;

import com.alurachallenge.foro.hub.domain.topico.Topico;
import com.alurachallenge.foro.hub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> createTopic(@Valid @RequestBody Topico topico, @AuthenticationPrincipal UserDetails user) throws URISyntaxException {
        Topico createdTopico = topicoService.createTopico(topico, user);
        return ResponseEntity.created(new URI("/topicos/" + createdTopico.getId())).body(createdTopico);
    }

    @GetMapping
    public List<Topico> getAllTopics() {
        return topicoService.getAllTopicos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicoService.deleteTopico(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopic(@PathVariable Long id, @Valid @RequestBody Topico topico) {
        Topico updatedTopico = topicoService.updateTopico(id, topico);
        return ResponseEntity.ok(updatedTopico);
    }
}
