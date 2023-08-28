package org.example.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.example.Test;

import java.util.Date;
import java.util.Scanner;

public class IhmController {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();



        int choice;



        do {
            System.out.println("=== Product Manager ===");
            System.out.println("1. Afficher la liste des produits entre 2 date");
            System.out.println("2. Afficher la reference et les numeros des produits inferieure au stock données ");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne


            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    EnterDate(scanner);
                    break;
                case 2:
                    Enterstock(scanner);
                    break;


                case 0:
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choice != 0);






    }

    private static void Enterstock(Scanner scanner) {
        System.out.println("entrer le stock");
        Scanner stock= scanner;
        Test.productByStock(int stock);
    }

    private static void EnterDate(Scanner scanner) {
        System.out.println("entrer la date de debut");
        String startdate= String.valueOf(scanner);
        System.out.println("entrer la date de fin");
        EnterDate(Scanner scanner);
        String enddate = String.valueOf(scanner);
        Test.productByDate(startdate, enddate);
//new Date()

    }


}

