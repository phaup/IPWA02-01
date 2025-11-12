package de.iubh.likeherotozero.controller;

import de.iubh.likeherotozero.model.Scientist;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped 
public class SessionBean implements Serializable {

    private Scientist currentScientist;

    public boolean isLoggedIn() {
        return currentScientist != null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        currentScientist = null;
        return "/index.xhtml?faces-redirect=true"; 
    }
    
    // Getter und Setter
    public Scientist getCurrentScientist() { return currentScientist; }
    public void setCurrentScientist(Scientist currentScientist) { this.currentScientist = currentScientist; }
}