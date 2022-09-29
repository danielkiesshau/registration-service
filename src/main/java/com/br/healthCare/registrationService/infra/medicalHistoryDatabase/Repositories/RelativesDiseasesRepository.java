package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories;

import com.br.healthCare.registrationService.data.medicalHistoryData.RelativesDiseases;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelativesDiseasesRepository extends CrudRepository<RelativesDiseases, Integer> {
    @Query(value = "SELECT * FROM relativesDiseases WHERE medicalHistoryId = ?1", nativeQuery = true)
    List<RelativesDiseases> findByMedicalHistoryId(int id);
}
