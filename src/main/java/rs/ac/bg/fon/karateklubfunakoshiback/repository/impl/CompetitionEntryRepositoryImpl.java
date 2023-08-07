/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository.impl;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.CompetitionEntry;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CompetitionEntryRepository;

import java.util.List;

/**
 *
 * @author Jeks
 */
@Repository
public class CompetitionEntryRepositoryImpl implements CompetitionEntryRepository {

    @Override
    public CompetitionEntry save(CompetitionEntry competitionEntry) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.persist(competitionEntry);
        return competitionEntry;
    }

    @Override
    public List<CompetitionEntry> getAllByCompetitionId(Long id) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        return em.createQuery("select r from CompetitionEntry r where r.competition.id = :id").setParameter("id", id).getResultList();

    }
}
