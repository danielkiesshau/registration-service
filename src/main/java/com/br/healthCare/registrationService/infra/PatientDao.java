package com.br.healthCare.registrationService.infra;


import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.pacientData.PatientAddress;
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

    @Override
    public void insertData() {
        patientRepository.save(patient);
    }

    @Override
    public void updateData(){
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getData(){
        Iterable<Patient> iterable = patientRepository.findAll();

        return new IterableHelper().toList(iterable);
    }

    @Override
    public void deleteData(){
        patientRepository.delete(patient);
    }



    public List<Patient> findByName() {
        List<Patient> result = patientRepository.findByName(patient.getName());
        return result;
    }


    public Patient findByEmail() {
        List<Patient> list = patientRepository.findByEmail(patient.getEmail());
        return list.get(0);
    }

    public Patient findByCPF() {
        List<Patient> list = patientRepository.findByCPF(patient.getCpf());
        return list.get(0);
    }

    public Optional<Patient> findById() {
        return patientRepository.findById(patient.getId());
    }
}
