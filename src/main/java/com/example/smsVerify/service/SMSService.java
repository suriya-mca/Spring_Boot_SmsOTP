package com.example.smsVerify.service;

import org.springframework.stereotype.Service;

@Service
public class SMSService {

	public String sendOTP(String phoneNumber) {
		return phoneNumber;
	}

	public String verifyOTP(String phoneNumber, String otpCode) {
		return phoneNumber+ " " + otpCode;
	}

}