package de.iubh.likeherotozero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Scientist")
public class Scientist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; // In der Praxis HASHEN!

    @OneToMany(mappedBy = "scientist")
    private List<Co2Data> contributedData = new ArrayList<>();

    // Getter und Setter
    // ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<Co2Data> getContributedData() { return contributedData; }
    public void setContributedData(List<Co2Data> contributedData) { this.contributedData = contributedData; }
}