package com.br.healthCare.registrationService.infra.PatientAddress;


import com.br.healthCare.registrationService.data.pacientData.PatientAddress;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientAddressDao implements RegistrationDAO<PatientAddress> {
    private PatientAddress patientAddress;


    public void setPatientAddress(PatientAddress patientAddress) {
        this.patientAddress = patientAddress;
    }

    @Autowired
    private PatientAddressRepository patientAddressRepository;

    @Override
    public void insertData(){
        patientAddressRepository.save(patientAddress);
    }

    @Override
    public void updateData(){
        patientAddressRepository.save(patientAddress);
    }

    @Override
    public List<PatientAddress> getData(){
        Iterable<PatientAddress> iterable = patientAddressRepository.findAll();

        return new IterableHelper().toList(iterable);
    }

    @Override
    public void deleteData(){
        patientAddressRepository.delete(patientAddress);
    }



}
