package com.events.controller;

import com.events.dto.Patient;
import com.events.service.PatientDischargeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientDischargeController {

  private PatientDischargeService patientDischargeService;

  public PatientDischargeController(PatientDischargeService patientDischargeService) {
    this.patientDischargeService = patientDischargeService;
  }

  @PostMapping("/discharge")
  public Patient dischargePatient(@RequestBody Patient patient) {
    patientDischargeService.dischargeThePatient(patient.getPatientId(), patient.getPatientName());
    return patient;
  }
}
