package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.Pacient;

public class PacientDao implements RegistrationDAO {
    private Pacient pacient;

    public PacientDao(){}

    @Override
    public void insertData(){}

    @Override
    public void updateData(){}

    @Override
    public void getData(){}

    @Override
    public void deleteData(){}

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }


}
