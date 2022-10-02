package com.br.healthCare.registrationService.domain.commands;

import com.br.healthCare.registrationService.infra.data.PatientData;
import com.br.healthCare.registrationService.infra.data.pacientData.PatientAddressData;
import com.br.healthCare.registrationService.domain.controllers.contracts.GetPatientRequest;
import com.br.healthCare.registrationService.infra.PatientDatabase.PatientAddressDao;
import com.br.healthCare.registrationService.infra.PatientDatabase.PatientDao;
import com.br.healthCare.registrationService.requests.PatientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PatientCommand {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientAddressDao patientAddressDao;

    private PatientData patientData;

    public List<PatientRequest> getAllPatients() {
        List<PatientRequest> responseList = new ArrayList<>();
         for(PatientData data : patientDao.getData()){
             responseList.add(convertFromPatientData(data));
         }
         return responseList;
    }

    public PatientRequest getPatient(GetPatientRequest request) {
        if (request.getId() != null) {
            return convertFromPatientData(patientDao.getPatientById(request.getId()));
        }

        if (request.getName() != null) {
            return convertFromPatientData(patientDao.getPatientByName(request.getName()));
        }

        if (request.getEmail() != null) {
            return convertFromPatientData(patientDao.getPatientByEmail(request.getEmail()));
        }

        if (request.getCpf() != null) {
            return convertFromPatientData(patientDao.getPatientByCPF(request.getCpf()));
        }

        return null;
    }

    public void createPatient(PatientRequest request, boolean isUpdate) throws Exception {
        this.patientData = convertFromPatientRequest(request);

        this.runValidations(isUpdate);

        if (patientData.getAddress() != null) {
            this.savePatientAddress(patientData.getAddress());
        }

        this.savePatient(patientData);
    }

    public void removePatient(Integer id) {
        PatientData patient = new PatientData();
        patient.setId(id);

        this.deletePatient(patient);
    }

    private PatientRequest getPatientById(int id) {
        return convertFromPatientData(patientDao.getPatientById(id));
    }

    private PatientRequest getPatientByName(String name) {
        return convertFromPatientData(patientDao.getPatientByName(name));

    }

    private PatientRequest getPatientByEmail(String email) {
        return convertFromPatientData(patientDao.getPatientByEmail(email));
    }

    private PatientRequest getPatientByCPF(String cpf) {
        return convertFromPatientData(patientDao.getPatientByCPF(cpf));
    }

    private void deletePatient(PatientData patient) {
        patientDao.setPatient(patient);
        patientDao.deleteData();
    }

    private void savePatient(PatientData patient) {
        patientDao.setPatient(patient);
        patientDao.insertData();
    }

    private void savePatientAddress(PatientAddressData address) {
        patientAddressDao.setPatientAddress(address);
        patientAddressDao.insertData();
    }

    private void validateEmail() throws Exception {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(patientData.getEmail());

        boolean isValidEmail = matcher.matches();

        if (!isValidEmail) {
            throw new Exception("Invalid Email");
        }
    }

    private void validateGenre() throws Exception {
        String genreStr = patientData.getGenre();
        Character genre = genreStr.charAt(0);

        boolean isChar = genreStr.length() == 1;
        boolean isValidGenre = genre == 'M' || genre == 'F' ;

        if (!isValidGenre || !isChar) {
            throw new Exception("Invalid Genre. Pass M or F");
        }
    }

    private void validatePhoneNumber() throws Exception {
        boolean isValidPhoneNumber = patientData.getPhoneNumber().length() == 11;

        if (!isValidPhoneNumber) {
            throw new Exception("Invalid Phone Number, it must have at 11 digits");
        }
    }

    private void validateCPF() throws Exception {
        patientDao.setPatient(patientData);
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

    public void updatePatient(PatientRequest request) throws Exception {
        this.createPatient(request, true);
    }

    private PatientRequest convertFromPatientData(PatientData data){
       return  PatientRequest.builder()
                .withName(patientData.getName())
                .withGenre(patientData.getGenre())
                .withAge(patientData.getAge())
                .withCpf(patientData.getCpf())
                .withEmail(patientData.getEmail())
                .withWeight(patientData.getWeight())
                .withInsuranceNumber(patientData.getHealthInsuranceNumber())
                .withPhoneNumber(patientData.getPhoneNumber())
                .withAddress(patientData.getAddress())
                .withFatherName(patientData.getFatherName())
                .withMotherName(patientData.getMotherName())
                .withPatientId(patientData.getId())
                .build();
    }

    private PatientData convertFromPatientRequest(PatientRequest request){
        return PatientData.builder()
                .withName(request.getName())
                .withGenre(request.getGenre())
                .withAge(request.getAge())
                .withCpf(request.getCpf())
                .withEmail(request.getEmail())
                .withWeight(request.getWeight())
                .withInsuranceNumber(request.getHealthInsuranceNumber())
                .withPhoneNumber(request.getPhoneNumber())
                .withAddress(request.getAddress())
                .withFatherName(request.getFatherName())
                .withMotherName(request.getMotherName())
                .build();
    }
}
