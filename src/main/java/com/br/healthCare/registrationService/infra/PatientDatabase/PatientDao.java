package com.br.healthCare.registrationService.infra.PatientDatabase;


import com.br.healthCare.registrationService.infra.data.PatientData;
import com.br.healthCare.registrationService.infra.PatientDatabase.patientRepositories.PatientRepository;
import com.br.healthCare.registrationService.infra.PatientDatabase.patientRepositories.PatientAddressRepository;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientDao implements RegistrationDAO<PatientData> {
    private PatientData patient;


    public void setPatient(PatientData patient) {
        this.patient = patient;
    }

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientAddressRepository patientAddressRepository;

    public PatientData getPatientById(int id) {
        return patientRepository.findById(id);
    }

    public PatientData getPatientByName(String name) {
        return patientRepository.findByName(name);
    }

    public PatientData getPatientByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    public PatientData getPatientByCPF(String cpf) {
       return patientRepository.findByCPF(cpf);
    }

    @Override
    public List<PatientData> getData() {
        Iterable<PatientData> iterable = patientRepository.getAll();

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



    public PatientData findByName() {
        return patientRepository.findByName(patient.getName());
    }


    public PatientData findByEmail() {
        return patientRepository.findByEmail(patient.getEmail());
    }

    public PatientData findByCPF() {
        return patientRepository.findByCPF(patient.getCpf());
    }

    public Optional<PatientData> findById(Integer patientId) {
        return patientRepository.findById(patientId);
    }
}
