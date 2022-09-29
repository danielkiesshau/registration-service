package com.br.healthCare.registrationService.domain.commands;

import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.pacientData.PatientAddress;
import com.br.healthCare.registrationService.infra.PatientAddressDao;
import com.br.healthCare.registrationService.infra.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientCommand {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientAddressDao patientAddressDao;
    public void createPatient(Patient patient) {
        PatientAddress patientAddress = patient.getAddress();

        if (patientAddress != null) {
            this.savePatientAddress(patientAddress);
        }

        this.savePatient(patient);
    }

    private void savePatient(Patient patient) {
        patientDao.setPatient(patient);
        patientDao.insertData();
    }

    private void savePatientAddress(PatientAddress address) {
        patientAddressDao.setPatientAddress(address);
        patientAddressDao.insertData();
    }
}
