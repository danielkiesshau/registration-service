package com.br.healthCare.registrationService.infra.Patient;


import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.pacientData.PatientAddress;
import com.br.healthCare.registrationService.infra.PatientAddress.PatientAddressRepository;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientDao implements RegistrationDAO<Patient> {
    private Patient patient;


    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientAddressRepository patientAddressRepository;

    public Patient getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public Patient getPatientByName(String name) {
        return patientRepository.findByName(name);
    }

    public Patient getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public Patient getPatientByCPF(String cpf) {
       return patientRepository.findByCPF(cpf);
    }

    @Override
    public List<Patient> getData() {
        Iterable<Patient> iterable = patientRepository.getAll();

        return new IterableHelper().toList(iterable);
    }

    @Override
    public void insertData() {
        patientRepository.save(patient);
    }



    @Override
    public void updateData(){
        patientRepository.save(patient);
    }

    @Override
    public void deleteData(){
        patientRepository.deleteById(patient.getId());
    }



    public Patient findByName() {
        return patientRepository.findByName(patient.getName());
    }


    public Patient findByEmail() {
        return patientRepository.findByEmail(patient.getEmail());
    }

    public Patient findByCPF() {
        return patientRepository.findByCPF(patient.getCpf());
    }

    public Optional<Patient> findById() {
        return patientRepository.findById(patient.getId());
    }
}
