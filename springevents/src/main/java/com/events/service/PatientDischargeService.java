package com.events.service;

import com.events.dischargeevent.PatientDischargeApplicationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatientDischargeService {

  @Autowired
  private ApplicationEventPublisher publisher;


  public void dischargeThePatient(String patientId, String patientName) {
    log.info("patient discharge process initiated {} ", patientName);
//    billingService.processBill();
//    medicalRecordsService.updatePatientHistory();
//    notificationService.notifyPatients();

    publisher.publishEvent(new PatientDischargeApplicationEvent(this, patientId, patientName));

    log.info("patient discharge process completed {} ", patientName);
  }
}
