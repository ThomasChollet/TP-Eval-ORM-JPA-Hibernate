package org.example.bo;

import jakarta.persistence.*;
import org.example.bo.enums.FishLivEnv;

import java.util.Date;


@Entity(name="fish")
public class Fish extends Animal{
    @Column
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

    public Fish(int id, Date birthDate, String color, PetStore petStore, FishLivEnv fishLivEnv) {
        super(id, birthDate, color, petStore);
        this.fishLivEnv = fishLivEnv;
    }

    public FishLivEnv getFishLivEnv() {
        return fishLivEnv;
    }

    public void setFishLivEnv(FishLivEnv fishLivEnv) {
        this.fishLivEnv = fishLivEnv;
    }
}