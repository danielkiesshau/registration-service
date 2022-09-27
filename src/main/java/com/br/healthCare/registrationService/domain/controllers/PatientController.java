package com.br.healthCare.registrationService.domain.controllers;

import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.infra.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/patient")
public class PatientController {

    @Autowired
    private PatientDao patientDao;

    @PostMapping(path="")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {

        // TODO: Criar DTO para recebimento de parametros
        Patient n = new Patient();
        n.setName(name);
        n.setEmail(email);

        // TODO: Validar parâmetros

        // TODO: passar chamada do repositório para um COMMAND (PatientCommand)
        patientDao.setPatient(n);
        patientDao.insertData();

        return "Saved";
    }

    @GetMapping(path="")
    public @ResponseBody Patient getByName(@RequestParam String name, @RequestParam String email) {
        Patient n = new Patient();
        n.setName(name);
        n.setEmail(email);

        // TODO: Validar parâmetros

        // TODO: passar chamada do repositório para um COMMAND (PatientCommand)
        patientDao.setPatient(n);
        return patientDao.findByEmail();
    }
}
