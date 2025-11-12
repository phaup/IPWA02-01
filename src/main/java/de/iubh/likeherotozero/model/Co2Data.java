package de.iubh.likeherotozero.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Co2Data", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"country_id", "dataYear"})
})
public class Co2Data implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int dataYear;

    @Column(nullable = false)
    private double emissionValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "scientist_id")
    private Scientist scientist; // Der Wissenschaftler, der die Daten eingetragen hat

    // Getter und Setter
    // ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getDataYear() { return dataYear; }
    public void setDataYear(int dataYear) { this.dataYear = dataYear; }
    public double getEmissionValue() { return emissionValue; }
    public void setEmissionValue(double emissionValue) { this.emissionValue = emissionValue; }
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
    public Scientist getScientist() { return scientist; }
    public void setScientist(Scientist scientist) { this.scientist = scientist; }
}