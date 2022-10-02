package com.br.healthCare.registrationService.infra.PatientDatabase;


import com.br.healthCare.registrationService.infra.data.pacientData.PatientAddressData;
import com.br.healthCare.registrationService.infra.PatientDatabase.patientRepositories.PatientAddressRepository;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientAddressDao implements RegistrationDAO<PatientAddressData> {
    private PatientAddressData patientAddressData;


    public void setPatientAddress(PatientAddressData patientAddressData) {
        this.patientAddressData = patientAddressData;
    }

    @Autowired
    private PatientAddressRepository patientAddressRepository;

    @Override
    public void insertData(){
        patientAddressRepository.save(patientAddressData);
    }

    @Override
    public void updateData(){
        patientAddressRepository.save(patientAddressData);
    }

    @Override
    public List<PatientAddressData> getData(){
        Iterable<PatientAddressData> iterable = patientAddressRepository.findAll();

        return new IterableHelper().toList(iterable);
    }

    @Override
    public void deleteData(){
        patientAddressRepository.delete(patientAddressData);
    }



}
