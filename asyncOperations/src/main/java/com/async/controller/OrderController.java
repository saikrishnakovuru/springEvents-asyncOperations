package com.async.controller;

import com.async.dto.Order;
import com.async.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


  @Autowired
  private OrderService orderService;

  @PostMapping("/orders")
  public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
    orderService.placeOrder(order); // synchronous
    // asynchronous
    orderService.notifyUser(order);
    orderService.assignVendor(order);
    orderService.packaging(order);
    orderService.assignDeliveryPartner(order);
    orderService.assignTrailerAndDispatch(order);
    return ResponseEntity.ok(order);
  }
}
