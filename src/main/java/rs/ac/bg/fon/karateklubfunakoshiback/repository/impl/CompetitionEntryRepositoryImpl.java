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

}
