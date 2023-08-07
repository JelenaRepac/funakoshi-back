/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.service;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.CompetitionEntry;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CompetitionEntryRepository;

import java.util.List;

/**
 *
 * @author Jeks
 */
@Service
public class CompetitionEntryService {

    @Autowired
    private CompetitionEntryRepository competitionEntryRepository;



    public CompetitionEntry save(CompetitionEntry competitionEntry) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            CompetitionEntry dbCompetition= competitionEntryRepository.save(competitionEntry);
            em.getTransaction().commit();
            return dbCompetition;
        } catch( Exception e){
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public List<CompetitionEntry> getAllByCompetitionId(Long id){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try {

            List<CompetitionEntry> dbEntries = competitionEntryRepository.getAllByCompetitionId(id);
            em.getTransaction().commit();
            return dbEntries;
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

}
