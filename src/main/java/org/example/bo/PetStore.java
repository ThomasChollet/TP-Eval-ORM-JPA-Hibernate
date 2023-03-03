package org.example.bo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "petStore")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String managerName;

    @ManyToMany
    @JoinTable(name = "petstorsproduct",
            joinColumns = @JoinColumn(name = "idpetstore"),
            inverseJoinColumns = @JoinColumn(name = "idproduct"))
    private List<Product> products = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "petstore_animal",
            joinColumns = @JoinColumn(name = "id_petstore"),
            inverseJoinColumns = @JoinColumn(name = "id_animal"))
    private List<Animal> animals = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "idaddress")
    private Address address;


    public PetStore() {
    }

    public PetStore(String name,  String managerName, List<Product> products, Address address) {
        this.name = name;
        this.address = address;
        this.managerName = managerName;
        this.products = products;
    }

    public PetStore(int id, String name, Address address, String managerName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.managerName = managerName;
        this.products = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimalsToPetStore(Animal animal) {
        this.animals.add(animal);
    }

    public void removeAnimalFromPetStore(Animal animal){
        this.animals.remove(animal);
    }
}