package com.acadl.medi_hub.service;

import com.acadl.medi_hub.entity.Consulta;
import com.acadl.medi_hub.entity.Medico;
import com.acadl.medi_hub.entity.Paciente;
import com.acadl.medi_hub.repository.ConsultaRepository;
import com.acadl.medi_hub.repository.MedicoRepository;
import com.acadl.medi_hub.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public Consulta cadastrar(Consulta consulta, Long pacienteId, Long medicoId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente com id " + pacienteId + " não encontrado"));
        Medico medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico com id " + medicoId + " não encontrado"));
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        return consultaRepository.save(consulta);
    }
}
