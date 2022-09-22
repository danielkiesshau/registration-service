package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.MedicalHistory;


public class MedicalHistoryDao implements RegistrationDAO{
    private final MedicalHistory medicalHistory;

    public MedicalHistoryDao(MedicalHistory medicalHistory){
        this.medicalHistory = medicalHistory;
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
