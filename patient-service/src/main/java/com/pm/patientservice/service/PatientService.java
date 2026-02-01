package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.dto.PatientResponseDto;
import com.pm.patientservice.exception.EmailAlreadyExists;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    PatientRepository patientRepository;

    PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    public List<PatientResponseDto> getAllPateints(){
        List<Patient> patients=patientRepository.findAll();

        List<PatientResponseDto> patientResponseDtos=patients.stream().map(PatientMapper::toDto).toList();

        return patientResponseDtos;
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto){
        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExists("Email Already Exists : "+patientRequestDto.getEmail());
        }
        Patient patient= patientRepository.save(PatientMapper.toModel(patientRequestDto));
        return PatientMapper.toDto(patient);
    }
}
