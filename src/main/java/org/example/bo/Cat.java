package org.example.bo;


import javax.persistence.*;
import java.util.Date;

@Entity(name="cat")
public class Cat extends Animal{
    @Column
    private String idShip;

    public Cat() {
    }

    public Cat(Date birthDate, String color, PetStore petStore, String idShip) {
        super(birthDate, color, petStore);
        this.idShip = idShip;
    }

    public Cat(Date birthDate, String color, String idShip) {
        super(birthDate, color);
        this.idShip = idShip;
    }



    public String getIdShip() {
        return idShip;
    }

    public void setIdShip(String idShip) {
        this.idShip = idShip;
    }
}