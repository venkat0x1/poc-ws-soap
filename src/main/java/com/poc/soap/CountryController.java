package com.poc.soap;

import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountryController {


    @Autowired
    private CountryInfoService countryInfoService;


    @GetMapping
    public CountryInfoDTO getCountryInfoByCode(@RequestParam(name = "code",defaultValue = "US") String code){

        CountryInfoServiceSoapType countryInfoServiceSoap = countryInfoService.getCountryInfoServiceSoap();

        CountryInfoDTO countryInfo = new CountryInfoDTO();
        countryInfo.setName(countryInfoServiceSoap.countryName(code));
        countryInfo.setCode(code);
        countryInfo.setCurrency(countryInfoServiceSoap.currencyName(code));
        countryInfo.setLanguage(countryInfoServiceSoap.languageName(code));

        return countryInfo;
    }

}
