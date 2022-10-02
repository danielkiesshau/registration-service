package com.br.healthCare.registrationService.infra.PatientDatabase.patientRepositories;

import com.br.healthCare.registrationService.infra.data.PatientData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<PatientData, Integer> {
    @Query(value = "SELECT * FROM patient_data WHERE id = ?1 LIMIT 1", nativeQuery = true)
    PatientData findById(int id);

    @Query(value = "SELECT * FROM patient_data WHERE name = ?1", nativeQuery = true)
    PatientData findByName(String name);

    @Query(value = "SELECT * FROM patient_data WHERE email = ?1 LIMIT 1", nativeQuery = true)
    PatientData findByEmail(String email);

    @Query(value = "SELECT * FROM patient_data WHERE cpf = ?1 LIMIT 1", nativeQuery = true)
    PatientData findByCPF(String cpf);

    @Query(value = "SELECT * FROM patient_data", nativeQuery = true)
    List<PatientData> getAll();
}
