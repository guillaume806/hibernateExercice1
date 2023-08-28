package org.example;

import org.example.entities.Personne;
import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

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

//        session.getTransaction().begin();
//        Product p = session.load(Product.class,2L);
//        System.out.println(p.getMarque());

        //On supprimme avec la methode delete

//        session.getTransaction().begin();
//        Product p = session.load(Product.class,3L);
//        System.out.println(p.getMarque());
//        session.delete(p);
//        session.getTransaction().commit();


        // MODIFIER PRODUIT

//        session.getTransaction().begin();
//        Product p = session.load(Product.class,1L);
//        p.setMarque("VANS");
//        session.update(p);
//        session.getTransaction().commit();

        // Récupérer la liste des produit
        // le support utilise l'interface query au lieu de la classe générique query (l'interface est dépréciée)
        Query<Product> productQuery = session.createQuery("from Product");

        System.out.println("################ List");
        // avec la liste
        List<Product> products = productQuery.list();
        for (Product p: products) {
            System.out.println(p.getMarque());
        }


    }
}
