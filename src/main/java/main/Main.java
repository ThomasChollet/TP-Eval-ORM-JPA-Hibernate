package main;

import org.example.bo.*;
import org.example.bo.enums.*;


import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------- Start -------------------");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address address = new Address("10", "rue des Roses", "44200", "Nantes");
        em.persist(address);
        Address address2 = new Address("9", "place du muguet", "44130", "Le Gâvre");
        em.persist(address2);
        Address address3 = new Address("63", "rue de l'église", "86200", "Nice");
        em.persist(address3);

        Product product1 = new Product("EAERT21", "shampooing poils brillants", TypeProduit.cleaning, 12.2);
        em.persist(product1);
        Product product2 = new Product("FDSFS32", "Croquettes proplan", TypeProduit.food, 32.1);
        em.persist(product2);
        Product product3 = new Product("HJHKJ56", "shampooing poils brillants", TypeProduit.accessory, 20.5);
        em.persist(product3);

        Set<Product> productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);

        PetStore petStore = new PetStore("Pet Shop", "Audrey Adde", productSet, address);
        em.persist(petStore);
        PetStore petStore2 = new PetStore("Shop and Pet", "Inès Boucard", productSet, address2);
        em.persist(petStore2);
        PetStore petStore3 = new PetStore("All for your pet", "Erwann Leducq", productSet, address3);
        em.persist(petStore3);

        Fish fish1 = new Fish(new Date(2023, 10, 12), "bleu", petStore, FishLivEnv.fresh_water);
        em.persist(fish1);
        Fish fish2 = new Fish(new Date(2022, 11, 12), "vert",petStore2,  FishLivEnv.sea_water);
        em.persist(fish2);
        Fish fish3 = new Fish(new Date(2023, 3, 2), "rouge",petStore3, FishLivEnv.fresh_water);
        em.persist(fish3);


        Cat cat1 = new Cat(new Date(2023, 3, 2), "blanc", petStore, "GGHYTB21");
        em.persist(cat1);
        Cat cat2 = new Cat(new Date(2022, 6, 20), "roux", petStore2, "DGRSGD23");
        em.persist(cat2);
        Cat cat3 = new Cat(new Date(2021, 9, 3), "tricolor", petStore3, "FGFSSGH67");
        em.persist(cat3);

        em.getTransaction().commit();

        TypedQuery<Animal> findAllQUery = em.createQuery("from Animal where petStore=2L", Animal.class);
        System.out.println(findAllQUery.getResultList());

        em.close();
        emf.close();
    }
}