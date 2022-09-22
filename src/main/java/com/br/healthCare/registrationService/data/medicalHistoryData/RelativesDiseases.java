package com.br.healthCare.registrationService.data.medicalHistoryData;

public class RelativesDiseases {

    private String kinshipDegree;
    private String diseaseName;

    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public RelativesDiseases setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
        return this;
    }
}
