package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Query(value = "SELECT * FROM patient WHERE name = ?1", nativeQuery = true)
    List<Patient> findByName(String name);

    @Query(value = "SELECT * FROM patient WHERE email = ?1 LIMIT 1", nativeQuery = true)
    List<Patient> findByEmail(String email);

    @Query(value = "SELECT * FROM patient WHERE cpf = ?1 LIMIT 1", nativeQuery = true)
    List<Patient> findByCPF(int cpf);
}
