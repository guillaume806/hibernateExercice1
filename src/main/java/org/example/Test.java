package org.example;

import org.example.entities.Personne;
import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Date;

public class Test {
    public static void main(String[] args){
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();

        // Ajout d'un produit

//        session.getTransaction().begin();
//        Product pro = new Product();
//        pro.setMarque("addidas");
//        pro.setPrix(Double.valueOf("55.2"));
//        pro.setStock(Integer.parseInt("58"));
//        pro.setDateAchat(Date.valueOf("2021-12-6"));
//        pro.setReference("5454558");
//        session.save(pro);
//        System.out.println("ID du produit : " + pro.getId());
//
//        session.getTransaction().commit();




        // Récupérer un produit

        session.getTransaction().begin();
        Product p = session.load(Product.class,2L);
        System.out.println(p.getMarque());
    }
}
