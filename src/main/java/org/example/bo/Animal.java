package org.example.bo;


import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private Date birthDate;
    @Column
    private String color;

    @ManyToOne(optional = false)
    private PetStore petStore;

    public Animal() {
    }

    public Animal(Date birthDate, String color, PetStore petStore) {
        this.birthDate = birthDate;
        this.color = color;
        this.petStore = petStore;
    }

    public Animal(Date birthDate, String color) {
        this.birthDate = birthDate;
        this.color = color;
    }

    public Animal(int id, Date birthDate, String color, PetStore petStore) {
        this.id = id;
        this.birthDate = birthDate;
        this.color = color;
        this.petStore = petStore;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}