/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.dbconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.persistence.EntityManager;
/**
 *
 * @author Jeks
 */
public class EntityManagerProvider {
    
    private static EntityManagerProvider instance;
    private static EntityManager em;
    private static Session session;
    private SessionFactory sessionFactory;

    public EntityManagerProvider() {
        sessionFactory= new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public static EntityManagerProvider getInstance(){
        if(instance== null) instance = new EntityManagerProvider();
        return instance;
    }
    
    public EntityManager getEntityManager(){
        if(!session.isOpen()){
            session= sessionFactory.openSession();
        }
        if(em == null || !em.isOpen()){
            em= session.getEntityManagerFactory().createEntityManager();
        }
        
        return em;
    }
    
    public void closeSession(){
        if(session.isOpen())
            session.close();
    }
}
