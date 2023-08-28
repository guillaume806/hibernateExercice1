package org.example;

import org.example.entities.Product;
import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class Test {


    private static StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
    private static SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

    private static Session session = sessionFactory.openSession();
    public static void main(String[] args){


        // Ajout d'un produit

//        session.getTransaction().begin();
//        Product pro = new Product();
//        pro.setMarque("addidas");
//        pro.setPrix(Double.valueOf("105.2"));
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



        //afficher liste des produits>100euros

//        Query<Product> productQuery1 = session.createQuery("from Product where prix >= '100' ");
//        // Récupérer une liste avec les personnes dont le nom est toto
//        List<Product> productList = productQuery1.list();
//        for (Product p: productList) {
//            System.out.println(p.getMarque());
//        }




    }
    private static void productByDate(Date startDate,Date endDate) {
        //  Date startDate;
        //  Date endDate;
        Query<Product> query = session.createQuery("from Product where dateachat BETWEEN :startDate AND :endDate");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<Product> productList = query.list();
        for (Product p : productList) {
            System.out.println(p.getMarque());
        }

    }
}
