package com.br.healthCare.registrationService.requests.requestComplements;

public class RelativesDiseases {

    private String kinshipDegree;
    private String diseaseName;

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

        public RelativesDiseases build(){
            RelativesDiseases response = new RelativesDiseases();
            response.setDiseaseName(this.diseaseName);
            response.setKinshipDegree(this.kinshipDegree);

            return response;
        }
    }

}
