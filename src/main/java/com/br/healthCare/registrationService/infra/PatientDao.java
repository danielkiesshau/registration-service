package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.Patient;

public class PatientDao implements RegistrationDAO {
    private final Patient patient;

    public PatientDao(Patient patient){
        this.patient = patient;
    }

    @Override
    public void insertData(){}

    @Override
    public void updateData(){}

    @Override
    public void getData(){}

    @Override
    public void deleteData(){}

}
