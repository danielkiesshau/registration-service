package com.br.healthCare.registrationService.domain.commands;

import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.pacientData.PatientAddress;

import com.br.healthCare.registrationService.infra.PatientAddress.PatientAddressDao;
import com.br.healthCare.registrationService.infra.Patient.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PatientCommand {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientAddressDao patientAddressDao;

    private Patient patient;
    public void createPatient(Patient patient) throws Exception {
        PatientAddress patientAddress = patient.getAddress();

        this.patient = patient;

        this.runValidations();

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

    private void validateEmail() throws Exception {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(patient.getEmail());

        boolean isValidEmail = matcher.matches();

        if (!isValidEmail) {
            throw new Exception("Invalid Email");
        }
    }

    private void validateGenre() throws Exception {
        String genreStr = patient.getGenre();
        Character genre = genreStr.charAt(0);

        boolean isChar = genreStr.length() == 1;
        boolean isValidGenre = genre == 'M' || genre == 'F' ;

        if (!isValidGenre || !isChar) {
            throw new Exception("Invalid Genre. Pass M or F");
        }
    }

    private void validatePhoneNumber() throws Exception {
        boolean isValidPhoneNumber = patient.getPhoneNumber().length() == 11;

        if (!isValidPhoneNumber) {
            throw new Exception("Invalid Phone Number, it must have at 11 digits");
        }
    }

    private void validateCPF() throws Exception {
        patientDao.setPatient(patient);
        boolean isCPFExistent = patientDao.findByCPF() != null;

        if (isCPFExistent) {
            throw new Exception("CPF already registered");
        }
    }

    private void runValidations() throws Exception {
        this.validateEmail();
        this.validateGenre();
        this.validatePhoneNumber();
        this.validateCPF();
    }
}
