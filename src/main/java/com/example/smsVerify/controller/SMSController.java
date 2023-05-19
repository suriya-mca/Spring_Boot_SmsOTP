package com.example.smsVerify.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smsVerify.service.SMSService;
import com.example.smsVerify.model.*;

@RestController 
@RequestMapping("/api/v1")
public class SMSController {

	private final SMSService smsService;

	public SMSController(SMSService smsService) {
		this.smsService = smsService;
	}

	@PostMapping("/sendOTP")
	public String processOTP(@RequestBody SMSSendRequest sendRequest) {

		return smsService.sendOTP(sendRequest.phoneNumber());

	}

	@PostMapping("/verifyOTP")
	public String verifyOTP(@RequestBody SMSVerifyRequest verifyRequest) {

		return smsService.verifyOTP(verifyRequest.phoneNumber(), verifyRequest.otpCode());
		
	}

}