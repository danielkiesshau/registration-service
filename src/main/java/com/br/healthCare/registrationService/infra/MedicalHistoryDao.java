package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.MedicalHistory;

import java.util.List;


public class MedicalHistoryDao implements RegistrationDAO<MedicalHistory> {
    private final MedicalHistory medicalHistory;

    public MedicalHistoryDao(MedicalHistory medicalHistory){
        this.medicalHistory = medicalHistory;
    }

    @Override
    public void insertData(){}

    @Override
    public void updateData(){}

    @Override
    public List<MedicalHistory> getData(){
        return null;
    }

    @Override
    public void deleteData(){}

}
