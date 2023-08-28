package org.example;

import org.example.entities.Personne;
import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class test {
    public static void main(String[] args){
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();

        // Ajout d'un produit
        session.getTransaction().begin();
        Product pro = new Product();
        pro.setMarque("nike");
        pro.setPrix(Double.valueOf("50.2"));
        pro.setStock(Integer.parseInt("2"));
        pro.setDateAchat("12-12-2022");
        pro.setReference("545454");
        session.save(pro);
        System.out.println("ID du produit : " + pro.getId());

        session.getTransaction().commit();
    }
}
