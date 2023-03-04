package org.example.bo;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "petStore")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String managerName;

    @ManyToMany
    @JoinTable(name = "petstorsproduct",
            joinColumns = @JoinColumn(name = "idpetstore"),
            inverseJoinColumns = @JoinColumn(name = "idproduct"))
    private Set<Product> products = new HashSet<>();

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

    public PetStore(String name, String managerName, Set<Product> products, Address address) {
        this.name = name;
        this.address = address;
        this.managerName = managerName;
        this.products = products;
    }

    public PetStore(String name, Address address, String managerName) {
        this.name = name;
        this.address = address;
        this.managerName = managerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
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