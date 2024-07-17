package com.alurachallenge.foro.hub.service;

import com.alurachallenge.foro.hub.domain.topico.Topico;
import com.alurachallenge.foro.hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public Topico createTopic(Topico topico, UserDetails user) {
        topico.setUserEmail(user.getUsername());
        return topicoRepository.save(topico);
    }

    public List<Topico> getAllTopics() {
        return topicoRepository.findAll();
    }

    public void deleteTopic(Long id) {
        topicoRepository.deleteById(id);
    }

    public Topico updateTopic(Long id, Topico topico) {
        Topico existingTopic = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
        existingTopic.setTitle(topico.getTitle());
        existingTopic.setMessage(topico.getMessage());
        existingTopic.setCourseName(topico.getCourseName());
        return topicRepository.save(existingTopico);
    }
}

