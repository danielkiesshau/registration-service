package com.br.healthCare.registrationService.domain.commands;

import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.pacientData.PatientAddress;
import com.br.healthCare.registrationService.domain.controllers.contracts.GetPatientRequest;
import com.br.healthCare.registrationService.infra.PatientAddress.PatientAddressDao;
import com.br.healthCare.registrationService.infra.Patient.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PatientCommand {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientAddressDao patientAddressDao;

    private Patient patient;

    public List<Patient> getAllPatients() {
        return patientDao.getData();
    }

    public Patient getPatient(GetPatientRequest request) {
        if (request.getId() != null) {
            return patientDao.getPatientById(request.getId());
        }

        if (request.getName() != null) {
            return patientDao.getPatientByName(request.getName());
        }

        if (request.getEmail() != null) {
            return patientDao.getPatientByEmail(request.getEmail());
        }

        if (request.getCpf() != null) {
            return patientDao.getPatientByCPF(request.getCpf());
        }

        return null;
    }

    public void createPatient(Patient patient, boolean isUpdate) throws Exception {
        PatientAddress patientAddress = patient.getAddress();

        this.patient = patient;

        this.runValidations(isUpdate);

        if (patientAddress != null) {
            this.savePatientAddress(patientAddress);
        }

        this.savePatient(patient);
    }

    public void removePatient(Integer id) {
        Patient patient = new Patient();
        patient.setId(id);

        this.deletePatient(patient);
    }

    private Patient getPatientById(int id) {
        return patientDao.getPatientById(id);
    }

    private Patient getPatientByName(String name) {
        return patientDao.getPatientByName(name);
    }

    private Patient getPatientByEmail(String email) {
        return patientDao.getPatientByEmail(email);
    }

    private Patient getPatientByCPF(String cpf) {
        return patientDao.getPatientByCPF(cpf);
    }

    private void deletePatient(Patient patient) {
        patientDao.setPatient(patient);
        patientDao.deleteData();
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

    private void runValidations(boolean shouldIgnoreCPF) throws Exception {
        this.validateEmail();
        this.validateGenre();
        this.validatePhoneNumber();

        if (!shouldIgnoreCPF) this.validateCPF();
    }

    public void updatePatient(Patient patient) throws Exception {
        this.createPatient(patient, true);
    }
}
