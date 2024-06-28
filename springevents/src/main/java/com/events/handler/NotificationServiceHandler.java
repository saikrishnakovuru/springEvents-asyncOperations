package com.events.handler;

import com.events.dischargeevent.PatientDischargeApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceHandler {

  @EventListener
  @Async
  public void notifyPatients(PatientDischargeApplicationEvent event) {
    System.out.println("Notification Service: Notifying the patient " + event.getPatientName());
  }
}
