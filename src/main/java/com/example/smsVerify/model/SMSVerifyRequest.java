package com.example.smsVerify.model;

public record SMSVerifyRequest(String phoneNumber, String otpCode) {

}