package com.br.healthCare.registrationService.data.medicalHistoryData;

import com.br.healthCare.registrationService.data.MedicalHistory;

import javax.persistence.*;

@Entity
public class RelativesDiseases {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String kinshipDegree;
    private String diseaseName;
    @OneToOne
    @JoinColumn(name = "meicalHistory_id", foreignKey = @ForeignKey(name = "id"))
    private MedicalHistory medicalHistoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public MedicalHistory getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(MedicalHistory medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
    }
}
