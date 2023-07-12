/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competition;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CompetitionRepository;

/**
 *
 * @author Jeks
 */
@Repository
public class CompetitionRepositoryImpl implements CompetitionRepository {

    @Override
    public List<Competition> getAll() {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        List<Competition> dbResults = em.createQuery("select c from Competition c").getResultList();
        return dbResults;
    }

    @Override
    public void deleteCompetition(Long id) {
      EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
      Competition dbCompetition = em.find(Competition.class, id);
      em.remove(dbCompetition);
    }

    @Override
    public Competition save(Competition competition) {
       EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
       em.persist(competition);
       return competition;
    }

    @Override
    public Competition update(Competition competition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
