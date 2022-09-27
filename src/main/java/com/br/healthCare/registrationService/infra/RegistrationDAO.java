package com.br.healthCare.registrationService.infra;

import java.util.List;

public interface RegistrationDAO<T> {

    void insertData();
    List<T> getData();
    void updateData();
    void deleteData();
}
