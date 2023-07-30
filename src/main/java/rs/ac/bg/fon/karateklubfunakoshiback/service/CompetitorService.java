/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.service;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competition;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competitor;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CompetitorRepository;

/**
 *
 * @author Jeks
 */
@Service
public class CompetitorService {

    @Autowired
    private CompetitorRepository competitorRepository;

    public Competitor update(Competitor competitor) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{

            Competitor dbCompetitor = competitorRepository.update(competitor);
            System.out.println(dbCompetitor);
            em.getTransaction().commit();
            return dbCompetitor;
        } catch( Exception e){
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public Competitor save(Competitor competitor) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            Competitor dbCompetitor = competitorRepository.save(competitor);
            em.getTransaction().commit();
            return dbCompetitor;
        }catch(Exception e){
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }

    }

}
