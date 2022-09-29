package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.pacientData.PatientAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientAddressRepository extends CrudRepository<PatientAddress, Integer> {
}
