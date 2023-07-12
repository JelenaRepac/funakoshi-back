/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.service;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.CityDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.City;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CityRepository;

/**
 *
 * @author Jeks
 */
@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAll() {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            List<City> dbCities= cityRepository.getAll();
            em.getTransaction().commit();
            return dbCities;
        }catch(Exception ex){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw ex;
        }finally{
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public City getById(Long id) {
       EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            City dbCity= cityRepository.getById(id);
            em.getTransaction().commit();
            return dbCity;
        }catch(Exception ex){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw ex;
        }finally{
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    
    
    
}
