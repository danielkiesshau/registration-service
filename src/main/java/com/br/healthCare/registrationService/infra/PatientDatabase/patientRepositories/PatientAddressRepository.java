package com.br.healthCare.registrationService.infra.PatientDatabase.patientRepositories;

import com.br.healthCare.registrationService.infra.data.pacientData.PatientAddressData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientAddressRepository extends CrudRepository<PatientAddressData, Integer> {
}
