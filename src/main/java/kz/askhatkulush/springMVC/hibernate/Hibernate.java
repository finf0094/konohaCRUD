package kz.askhatkulush.springMVC.hibernate;

import kz.askhatkulush.springMVC.konoha.Heroes;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Hibernate {
    static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Heroes.class)
            .buildSessionFactory();

    public void addHero(Heroes hero) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(hero);
            session.beginTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void deleteHero(int heroId) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("delete from Heroes where id=: value");
            query.setParameter("value", heroId);
            query.executeUpdate();
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public ArrayList<Heroes> getHeroes() {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Heroes");
            ArrayList<Heroes> heroes = (ArrayList<Heroes>) query.list();
            session.getTransaction().commit();
            return heroes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
