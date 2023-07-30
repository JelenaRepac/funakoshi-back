/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository.impl;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competitor;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CompetitorRepository;

/**
 *
 * @author Jeks
 */
@Repository
public class CompetitorRepositoryImpl implements CompetitorRepository{

    @Override
    public Competitor update(Competitor competitor) {
        EntityManager em=EntityManagerProvider.getInstance().getEntityManager();
        Competitor dbCompetitor = em.find(Competitor.class, competitor.getId());
        if(dbCompetitor==null){
            System.out.println("Competition doesnt exists!");
        }
        else{

            Competitor updatedCompetitor = em.merge(competitor);
            return updatedCompetitor;
        }
        return dbCompetitor;
    }

    @Override
    public Competitor save(Competitor competitor) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.persist(competitor);
        System.out.println(competitor.toString());
        return competitor;
    }

}
