package com.acadl.medi_hub.config;


import com.acadl.medi_hub.entity.Medico;
import com.acadl.medi_hub.entity.Paciente;
import com.acadl.medi_hub.repository.MedicoRepository;
import com.acadl.medi_hub.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        return args -> {

            if (medicoRepository.count() == 0) {
                medicoRepository.save(new Medico("Dr. Ricardo Menezes", "CRM-CE-24567", "Cardiologista"));
                medicoRepository.save(new Medico("Dra. Juliana Costa", "CRM-CE-88901", "Ortopedista"));
                System.out.println("=====> Tabela medicos populada.");
            }


            if (pacienteRepository.count() == 0) {
                pacienteRepository.save(new Paciente("João Silva", "32165498700", LocalDate.of(1980, 5, 10), "85991234567"));
                pacienteRepository.save(new Paciente("Maria Oliveira", "15975348622", LocalDate.of(1995, 11, 28), "85999887766"));
                System.out.println("=====> Tabela pacientes populada.");
            }
        };
    }
}
