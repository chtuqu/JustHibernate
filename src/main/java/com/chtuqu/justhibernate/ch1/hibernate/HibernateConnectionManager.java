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

    private static SessionFactory createSessionFactory() {
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
