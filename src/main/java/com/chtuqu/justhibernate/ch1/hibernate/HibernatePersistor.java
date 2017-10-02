package com.chtuqu.justhibernate.ch1.hibernate;

import org.hibernate.Session;

public class HibernatePersistor {

    public <T> void persist(T obj) {
        Session session = HibernateConnectionManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    public <T> T query(Class<T> clazz, int id) {
        Session session = HibernateConnectionManager.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        T obj = session.get(clazz, id);
        session.getTransaction().commit();
        session.close();
        return obj;
    }
}
