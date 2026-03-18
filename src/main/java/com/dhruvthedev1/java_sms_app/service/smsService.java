package com.dhruvthedev1.java_sms_app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

@Service
public class SmsService {
  @Value("${twilio.sid}")
  private String accountSID;
  @Value("${twilio.auth.token}")
  private String authToken;
  @Value("${twilio.from.number}")
  private String fromNumber;

  @PostConstruct
  public void initialise() {
    Twilio.init(accountSID, authToken);
  }

  public String sendMessage(String toNumber, String messageBody) {
    Message message = Message.creator(
      new PhoneNumber(toNumber),
       new PhoneNumber(fromNumber),
        messageBody
        ).create();

        return message.getStatus().toString();
  }
}
