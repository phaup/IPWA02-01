package de.iubh.likeherotozero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Country")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 3)
    private String countryCode;

    @OneToMany(mappedBy = "country")
    private List<Co2Data> co2DataEntries = new ArrayList<>();

    // Getter und Setter
    // ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public List<Co2Data> getCo2DataEntries() { return co2DataEntries; }
    public void setCo2DataEntries(List<Co2Data> co2DataEntries) { this.co2DataEntries = co2DataEntries; }
}