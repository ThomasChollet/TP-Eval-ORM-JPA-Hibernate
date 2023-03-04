package org.example.bo;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private Date birthDate;
    @Column
    private String color;

    @ManyToOne
    @JoinColumn(name="IDPETSTORE")
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



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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