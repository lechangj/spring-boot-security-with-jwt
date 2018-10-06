package org.burloak.service;

import org.burloak.dto.CountryCodeDTO;

import java.util.List;

public interface CountryCodeService {
    List<CountryCodeDTO> getCountryCodes();

    String createCountryCode(CountryCodeDTO countryDTO);

    String deleteCountryCode(int id);
}
