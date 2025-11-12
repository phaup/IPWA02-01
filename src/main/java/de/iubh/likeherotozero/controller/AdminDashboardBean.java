package de.iubh.likeherotozero.controller;

import de.iubh.likeherotozero.dao.Co2DataDAO;
import de.iubh.likeherotozero.dao.CountryDAO;
import de.iubh.likeherotozero.model.Co2Data;
import de.iubh.likeherotozero.model.Country;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AdminDashboardBean implements Serializable {

    @Inject
    private Co2DataDAO co2DataDAO;
    
    @Inject
    private CountryDAO countryDAO;

    @Inject
    private SessionBean sessionBean; 

    private List<Country> countries;
    private Co2Data newData;
    
    // NEUE VARIABLE für die Dropdown-Auswahl
    private Long selectedCountryId; 

    @PostConstruct
    public void init() {
        countries = countryDAO.findAll();
        resetNewData();
    }
    
    private void resetNewData() {
        newData = new Co2Data();
        newData.setDataYear(java.time.Year.now().getValue()); 
        selectedCountryId = null; // Auch die ID zurücksetzen
    }

    public void saveData() {
        try {
            // BENUTZE DIE selectedCountryId, um das Land zu finden
            Country selectedCountry = countryDAO.find(selectedCountryId); 
            
            // Setze das gefundene Land auf das newData Objekt
            newData.setCountry(selectedCountry); 
            newData.setScientist(sessionBean.getCurrentScientist());
            
            co2DataDAO.save(newData);
            
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Erfolg", "Daten erfolgreich gespeichert."));
            
            resetNewData(); 
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Daten konnten nicht gespeichert werden. Eventuell existiert der Eintrag für Land/Jahr bereits."));
        }
    }

    // Getter und Setter
    public Co2Data getNewData() { return newData; }
    public void setNewData(Co2Data newData) { this.newData = newData; }
    public List<Country> getCountries() { return countries; }
    
    // NEUE GETTER/SETTER für die ID
    public Long getSelectedCountryId() { return selectedCountryId; }
    public void setSelectedCountryId(Long selectedCountryId) { this.selectedCountryId = selectedCountryId; }
}