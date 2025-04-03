package org.reproducer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.reproducer.entities.AppUser;

import java.util.List;

/*
 *----------------------------------------------------------------------------
 *                 🌟 Default (Template) Project 🌟
 *----------------------------------------------------------------------------
 *  📁 Package: org.reproducer
 *  👤 Author: hardik
 *  📅 Date: Wednesday, 02 April 2025
 *  ⏰ Time: 17:00
 *----------------------------------------------------------------------------
 *  Description:
 *  - Brief description of the file's purpose and functionality.
 *  - Additional details if necessary.
 *----------------------------------------------------------------------------
 */// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



        // Load Hibernate configuration and mappings
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Load Hibernate config

        // Build SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // Define HQL Query
        String hql = """
                SELECT DISTINCT u.id
                FROM AppUser u
                LEFT JOIN u.addresses a
                LEFT JOIN u.orders o
                LEFT JOIN o.orderItems oi
                LEFT JOIN oi.product p
                LEFT JOIN p.discounts d
                WHERE u.id = :userId
                AND (
                    CASE 
                        WHEN u.name = 'SPECIAL_USER' THEN TRUE
                        ELSE (
                            CASE
                                WHEN a.city = 'New York' THEN TRUE
                                ELSE (
                                    p.category.name = 'Electronics'
                                    OR d.code LIKE '%DISC%'
                                    OR u.id IN (
                                        SELECT u2.id
                                        FROM AppUser u2
                                        JOIN u2.orders o2
                                        JOIN o2.orderItems oi2
                                        JOIN oi2.product p2
                                        WHERE p2.price > (
                                            SELECT AVG(p3.price) FROM Product p3
                                        )
                                    )
                                )
                            END
                        )
                    END
                )
                """;

        // Track memory usage before execution
        Runtime runtime = Runtime.getRuntime();
        long totalMemoryBefore = runtime.totalMemory();
        long usedMemoryBefore = totalMemoryBefore - runtime.freeMemory();

        System.out.println("Memory Usage Before Create Query:");
        System.out.println("----------------------------");
        System.out.println("Total Memory: " + (totalMemoryBefore / 1024) + " KB");
        System.out.println("Used Memory : " + (usedMemoryBefore / 1024) + " KB");
        System.out.println();


        // Create query
        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("userId", 123L); // Replace with actual user ID

        // Track memory usage after execution
        long totalMemoryAfter = runtime.totalMemory();
        long usedMemoryAfter = totalMemoryAfter - runtime.freeMemory();

        System.out.println("Memory Usage After Create Query:");
        System.out.println("----------------------------");
        System.out.println("Total Memory: " + (totalMemoryAfter / 1024) + " KB");
        System.out.println("Used Memory : " + (usedMemoryAfter / 1024) + " KB");
        System.out.println();

        // Execute query
        List<Long> userIds = query.list();

        // Commit transaction
        transaction.commit();

        // Close session
        session.close();
        sessionFactory.close();



        // Print results
        System.out.println("Matching Users: " + userIds);
    }
}