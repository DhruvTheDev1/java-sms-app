package com.dhruvthedev1.java_sms_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhruvthedev1.java_sms_app.service.smsService;

@RestController
public class smsController {
  
  @Autowired
  private smsService smsService;

  @GetMapping("/sendSMS")
  private String sendSMS(@RequestParam String receipient, @RequestParam String message) {
    return smsService.sendMessage(receipient, message);
  }

}
