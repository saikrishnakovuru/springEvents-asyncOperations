package com.events.handler;

import com.events.dischargeevent.PatientDischargeApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BillingServiceHandler {

  @EventListener
  @Async
  public void processBill(PatientDischargeApplicationEvent event) {
    System.out.println("Billing Service: Finalizing bill for patient: " + event.getPatientName());
  }
}
