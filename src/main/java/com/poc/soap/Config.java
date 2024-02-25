package com.poc.soap;

import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CountryInfoService getCountryInfoService(){
        return new CountryInfoService();
    }

}
