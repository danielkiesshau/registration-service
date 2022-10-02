package com.br.healthCare.registrationService.requests.requestComplements;

public class RelativesDiseases {

    private String kinshipDegree;
    private String diseaseName;
    private Integer id;

    public String getKinshipDegree() {
        return kinshipDegree;
    }

    private void setKinshipDegree(String kinshipDegree) {
        this.kinshipDegree = kinshipDegree;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    private void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String kinshipDegree;
        private String diseaseName;
        private Integer id;

        public Builder withKinshipDegree(String kinshipDegree){
            this.kinshipDegree = kinshipDegree;
            return this;
        }

        public Builder withDiseaseName(String diseaseName){
            this.diseaseName = diseaseName;
            return this;
        }

        public Builder withId(Integer id){
            this.id = id;
            return this;
        }

        public RelativesDiseases build(){
            RelativesDiseases response = new RelativesDiseases();
            response.setDiseaseName(this.diseaseName);
            response.setKinshipDegree(this.kinshipDegree);
            response.setId(this.id);

            return response;
        }
    }

}
