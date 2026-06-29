package com.acadl.medi_hub.service;

import com.acadl.medi_hub.entity.Medico;
import com.acadl.medi_hub.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public List<Medico> listarPorNumeroDeConsultas() {
        return medicoRepository.findMedicosOrderByNumeroConsultas();
    }
}
