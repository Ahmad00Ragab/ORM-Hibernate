package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.find(Product.class,1);
            Product product1 = new Product();
            product1.setName("produc1");
            Product product2 = new Product();
            product2.setName("produc2");
            em.persist(product1);
            em.persist(product2);
            System.out.println(em.find(Product.class,1));
            System.out.println(em.find(Product.class,2));
            em.getTransaction().commit();
        } finally {

           
            em.close();
        }

    }
}
