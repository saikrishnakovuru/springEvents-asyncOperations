package com.async.service;

import com.async.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderService {

  private ProductAvailabilityService productAvailabilityService;
  private PaymentService paymentService;

  public OrderService(ProductAvailabilityService productAvailabilityService, PaymentService paymentService) {
    this.productAvailabilityService = productAvailabilityService;
    this.paymentService = paymentService;
  }

  public void placeOrder(Order order) throws InterruptedException {
    order.setTrackingId(UUID.randomUUID().toString());
    if (productAvailabilityService.checkProductAvailability(order.getProductId()))
      //handle exception here
      paymentService.processPayment(order);
    else
      throw new RuntimeException("Technical issue please retry");

  }

  @Async("asyncTaskExecutor")
  public void notifyUser(Order order) throws InterruptedException {
    Thread.sleep(4000L);
    log.info("Notified to the user " + Thread.currentThread().getName());
  }

  @Async("asyncTaskExecutor")
  public void assignVendor(Order order) throws InterruptedException {
    Thread.sleep(5000L);
    log.info("Assign order to vendor " + Thread.currentThread().getName());
  }

  @Async("asyncTaskExecutor")
  public void packaging(Order order) throws InterruptedException {
    Thread.sleep(2000L);
    log.info("Order packaging completed " + Thread.currentThread().getName());
  }

  @Async("asyncTaskExecutor")
  public void assignDeliveryPartner(Order order) throws InterruptedException {
    Thread.sleep(10000L);
    log.info("Delivery partner assigned " + Thread.currentThread().getName());
  }

  @Async("asyncTaskExecutor")
  public void assignTrailerAndDispatch(Order order) throws InterruptedException {
    Thread.sleep(3000L);
    log.info("Trailer assigned and Order dispatched " + Thread.currentThread().getName());
  }
}
