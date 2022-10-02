package com.br.healthCare.registrationService.infra.data.medicalHistoryData;

import com.br.healthCare.registrationService.requests.requestComplements.RelativesDiseases;

import javax.persistence.*;

@Entity
public class RelativesDiseasesData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String kinshipDegree;
    private String diseaseName;


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


    public String getKinshipDegree() {
        return kinshipDegree;
    }

    public void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
    }

    public Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String kinshipDegree;
        private String diseaseName;

        public Builder withKinshipDegree(String kinshipDegree){
            this.kinshipDegree = kinshipDegree;
            return this;
        }

        public Builder withDiseaseName(String diseaseName){
            this.diseaseName = diseaseName;
            return this;
        }

        public RelativesDiseasesData build(){
            RelativesDiseasesData response = new RelativesDiseasesData();
            response.setDiseaseName(this.diseaseName);
            response.setKinshipDegree(this.kinshipDegree);

            return response;
        }
    }
}
