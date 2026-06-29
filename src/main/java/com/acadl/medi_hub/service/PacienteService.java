package com.acadl.medi_hub.service;

import com.acadl.medi_hub.entity.Paciente;
import com.acadl.medi_hub.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public void remover(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente com id " + id + " não encontrado.");
        }
        pacienteRepository.deleteById(id);
    }
}
