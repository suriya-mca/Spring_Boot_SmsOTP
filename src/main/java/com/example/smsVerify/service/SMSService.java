package com.example.smsVerify.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

@Service
public class SMSService {

	@Value("${TWILIO_SERVICE_SID}")
    String SERVICE_SID;

	public String sendOTP(String phoneNumber) {
		
		try {
            Verification verification = Verification.creator(SERVICE_SID, phoneNumber, "sms").create();
            if("approved".equals(verification.getStatus()) || "pending".equals(verification.getStatus())) {
				return "OTP sent";
			}
			return "some problem";
        } 
        catch (ApiException exception) {
            return exception.getMessage();
        }

	}

	public String verifyOTP(String phoneNumber, String otpCode) {
		
		try {
            VerificationCheck verify = VerificationCheck.creator(SERVICE_SID).setCode(otpCode).setTo(phoneNumber).create();
            if("approved".equals(verify.getStatus())) {
                return "Valid code";
            }
            return "Invalid code";
        } 
        catch (ApiException exception) {
        	return exception.getMessage();
        }

	}

}