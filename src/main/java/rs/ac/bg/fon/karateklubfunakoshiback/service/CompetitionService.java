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
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competition;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.CompetitionRepository;

/**
 *
 * @author Jeks
 */
@Service
public class CompetitionService {


    @Autowired
    private CompetitionRepository competitionRepository;


    public List<Competition> getAll(){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            List<Competition> dbResult = competitionRepository.getAll();
            em.getTransaction().commit();
            return  dbResult;
        }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        } finally{
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }

    }

    public void deleteCompetition(Long id){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            competitionRepository.deleteCompetition(id);
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;
        } finally{
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }

    }

    public Competition save(Competition competition) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            Competition dbCompetition= competitionRepository.save(competition);
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
    public Competition update(Competition competition) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            Competition dbCompetition = competitionRepository.update(competition);
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

}
