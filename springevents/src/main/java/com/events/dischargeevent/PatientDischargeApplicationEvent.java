package com.events.dischargeevent;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class PatientDischargeApplicationEvent extends ApplicationEvent {

  private String patientId;
  private String patientName;

  public PatientDischargeApplicationEvent(Object source, String patientId, String patientName) {
    super(source);
    this.patientId = patientId;
    this.patientName = patientName;
  }
}
