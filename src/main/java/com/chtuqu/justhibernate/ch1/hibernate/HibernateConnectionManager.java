package com.chtuqu.justhibernate.ch1.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateConnectionManager {

    private static SessionFactory sessionFactory;

    static {
        createSessionFactory();
    }

    private HibernateConnectionManager() { }

    private static void createSessionFactory() {
        // a SessionFactory is set up once for an application!
        ServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure(). // configures settings from hibernate.cfg.xml
                build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            // the registry is normally destroyed by the SessionFactory, but due to failure while instantiating
            // we have to destroy it manually
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
