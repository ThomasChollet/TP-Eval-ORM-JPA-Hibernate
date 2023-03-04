package org.example.bo;

import org.example.bo.enums.FishLivEnv;

import javax.persistence.*;
import java.util.Date;


@Entity(name="fish")
public class Fish extends Animal{
    @Enumerated(EnumType.STRING)
    private FishLivEnv fishLivEnv;

    public Fish() {
    }

    public Fish(Date birthDate, String color, PetStore petStore, FishLivEnv fishLivEnv) {
        super(birthDate, color, petStore);
        this.fishLivEnv = fishLivEnv;
    }

    public Fish(Date birthDate, String color, FishLivEnv fishLivEnv) {
        super(birthDate, color);
        this.fishLivEnv = fishLivEnv;
    }
}