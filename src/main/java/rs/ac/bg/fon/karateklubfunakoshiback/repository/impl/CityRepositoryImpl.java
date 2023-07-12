/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.City;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CityRepository;

/**
 *
 * @author Jeks
 */
@Repository
public class CityRepositoryImpl implements CityRepository {

    @Override
    public List<City> getAll() {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        List<City> cities= em.createQuery("select c from City c").getResultList();
        return cities;
    }

    @Override
    public City getById(Long id) {
       EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
       City city= em.find(City.class, id);
       return city;
    }
    
}
