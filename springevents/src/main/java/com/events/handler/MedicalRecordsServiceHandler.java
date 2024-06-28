package com.events.handler;

import com.events.dischargeevent.PatientDischargeApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordsServiceHandler {

  @EventListener
  @Async
  public void updatePatientHistory(PatientDischargeApplicationEvent event) throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("Medical Record Service: Finalizing medical record for patient " + event.getPatientName());
  }
}
