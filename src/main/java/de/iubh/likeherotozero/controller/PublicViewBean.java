package de.iubh.likeherotozero.controller;

import de.iubh.likeherotozero.dao.Co2DataDAO;
import de.iubh.likeherotozero.dao.CountryDAO;
import de.iubh.likeherotozero.model.Co2Data;
import de.iubh.likeherotozero.model.Country;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named 
@ViewScoped 
public class PublicViewBean implements Serializable {

    @Inject 
    private CountryDAO countryDAO;
    
    @Inject
    private Co2DataDAO co2DataDAO;

    private List<Country> countries;
    private Long selectedCountryId;
    private Co2Data latestCo2Data;

    @PostConstruct 
    public void init() {
        countries = countryDAO.findAll();
    }

    public void loadData() {
        if (selectedCountryId != null) {
            Country selectedCountry = countryDAO.find(selectedCountryId);
            if (selectedCountry != null) {
                latestCo2Data = co2DataDAO.findLatestByCountry(selectedCountry);
            }
        } else {
            latestCo2Data = null;
        }
    }

    // Getter und Setter für die JSF-Seite
    public List<Country> getCountries() { return countries; }
    public Long getSelectedCountryId() { return selectedCountryId; }
    public void setSelectedCountryId(Long selectedCountryId) { this.selectedCountryId = selectedCountryId; }
    public Co2Data getLatestCo2Data() { return latestCo2Data; }
}