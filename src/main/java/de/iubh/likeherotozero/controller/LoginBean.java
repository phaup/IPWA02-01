package de.iubh.likeherotozero.controller;

import de.iubh.likeherotozero.dao.ScientistDAO;
import de.iubh.likeherotozero.model.Scientist;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped 
public class LoginBean {

    @Inject
    private ScientistDAO scientistDAO;

    @Inject
    private SessionBean sessionBean; 

    private String username;
    private String password;

    public String login() {
        Scientist scientist = scientistDAO.findByUsername(username);

        if (scientist != null && scientist.getPassword().equals(password)) {
            sessionBean.setCurrentScientist(scientist); 
            return "/admin/dashboard.xhtml?faces-redirect=true"; 
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login fehlgeschlagen", "Benutzername oder Passwort ungültig."));
            return null; 
        }
    }

    // Getter und Setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}