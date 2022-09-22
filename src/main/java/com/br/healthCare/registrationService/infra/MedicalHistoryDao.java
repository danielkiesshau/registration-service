package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.MedicalHistory;


public class MedicalHistoryDao implements RegistrationDAO{

    private MedicalHistory medicalHistory;

    public MedicalHistoryDao(){}

    @Override
    public void insertData(){}

    @Override
    public void updateData(){}

    @Override
    public void getData(){}

    @Override
    public void deleteData(){}

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

}
