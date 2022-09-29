package com.br.healthCare.registrationService.data.medicalHistoryData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RelativesDiseases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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
