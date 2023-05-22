package com.example.smsVerify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Value;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;

@Configuration
public class TwilioConfig {

	@Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Bean
    @Primary
    public void setUp() throws AuthenticationException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

}