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
import rs.ac.bg.fon.karateklubfunakoshiback.model.ResultMember;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.ResultMemberRepository;

/**
 *
 * @author Jeks
 */
@Service
public class ResultMemberService {
    
    @Autowired
    private ResultMemberRepository repository;
    
    
     
    public List<ResultMember> getAll(){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            List<ResultMember> dbResult = repository.getAll();
            em.getTransaction().commit();
            return dbResult;
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }
    
     public List<ResultMember> getAllByCompetitionId(Long id){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            List<ResultMember> dbResult = repository.getAllByCompetitionId(id);
            em.getTransaction().commit();
            return dbResult;
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public ResultMember save(ResultMember resultMember) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            ResultMember dbResultMember= repository.save(resultMember);
            em.getTransaction().commit();
            return dbResultMember;
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
