package org.burloak.controller;

import org.burloak.dto.CountryCodeDTO;
import org.burloak.service.CountryCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countrycodes")
public class CountryCodeController {
    @Autowired
    private CountryCodeService countryCodeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CountryCodeDTO> getCountries(){
        return countryCodeService.getCountryCodes();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority('ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createCountry(@RequestBody CountryCodeDTO countryDTO){
        return countryCodeService.createCountryCode(countryDTO);
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCountry(@RequestParam("id") int id){
        return countryCodeService.deleteCountryCode(id);
    }
}
