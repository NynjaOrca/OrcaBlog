package com.nynjaorca.orcablog.orcablog.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min=1, max=50, message=" (size must be between 1 and 50)")
    @Column(nullable = false, length = 50)
    private String genus;

    @Size(min=1, max=50, message=" (size must be between 1 and 50)")
    @Column(nullable = false, length = 50)
    private String species;

    @Size(min=1, max=100, message=" (size must be between 1 and 100)")
    @Column(nullable = false, unique = true, length = 100)
    private String commonName;

    @Size(min=1, max=500, message=" (size must be between 1 and 500)")
    @Column(nullable = false, length = 500)
    private String description;

    @Min(value=1, message=" value must be at least 1")
    @Max(value=100, message=" value must not exceed 100")
    @Column(nullable=false, length=100)
    private int strength;

    @Min(value=1, message=" value must be at least 1")
    @Max(value=100, message=" value must not exceed 100")
    @Column(nullable=false, length=100)
    private int dexterity;

    @Min(value=1, message=" value must be at least 1")
    @Max(value=100, message=" value must not exceed 100")
    @Column(nullable=false, length=100)
    private int defense;

    @Min(value=1, message=" value must be at least 1")
    @Max(value=100, message=" value must not exceed 100")
    @Column(nullable=false, length=100)
    private int speed;

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getStrength() { return strength; }

    public void setStrength(int strength) { this.strength = strength; }

    public int getDexterity() { return dexterity; }

    public void setDexterity(int dexterity) { this.dexterity = dexterity; }

    public int getDefense() { return defense; }

    public void setDefense(int defense) { this.defense = defense; }

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed; }
}
