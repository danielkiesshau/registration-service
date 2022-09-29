package com.br.healthCare.registrationService.data.medicalHistoryData;

import com.br.healthCare.registrationService.data.MedicalHistory;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SurgicalProcedures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String procedureName;
    private String complications;
    private Date date;
    @OneToOne
    @JoinColumn(name = "medicalHistory_id", foreignKey = @ForeignKey(name = "id"))
    private MedicalHistory medicalHistoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMedicalHistoryId() {
        return medicalHistoryId.getId();
    }

    public void setMedicalHistoryId(MedicalHistory medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public SurgicalProcedures setProcedureName(String procedureName) {
        this.procedureName = procedureName;
        return this;
    }

    public String getComplications() {
        return complications;
    }

    public SurgicalProcedures setComplications(String complications) {
        this.complications = complications;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public SurgicalProcedures setDate(Date date) {
        this.date = date;
        return this;
    }
}
