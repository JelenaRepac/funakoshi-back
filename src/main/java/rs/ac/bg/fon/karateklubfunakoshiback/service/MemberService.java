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
import rs.ac.bg.fon.karateklubfunakoshiback.dto.MemberDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Member;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Trainer;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.MemberRepository;

/**
 *
 * @author Jeks
 */
@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepository;
    
    public List<Member> getAll(){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            List<Member> dbResult = memberRepository.getAll();
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

    public void deleteMember(Long id) {
       EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
       em.getTransaction().begin();
       try{
           memberRepository.deleteMember(id);
           em.getTransaction().commit();
       } catch( Exception e){
          if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public Member save(Member member) {
       EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
       em.getTransaction().begin();
       try{
           Member dbMember= memberRepository.save(member);
           em.getTransaction().commit();
           return dbMember;
       } catch( Exception e){
          if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public Member getMemberById(Long id) {
      EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
       em.getTransaction().begin();
       try{
           Member dbMember= memberRepository.getById(id);
           em.getTransaction().commit();
           return dbMember;
       } catch( Exception e){
          if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public Member update(Member member) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
       try{
           Member dbMember= memberRepository.update(member);
           System.out.println(dbMember);
           em.getTransaction().commit();
           return dbMember;
       } catch( Exception e){
          if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }
    
     public Member getAllByCompetitor(Long competitorId){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            Member dbResult = memberRepository.getAllByCompetitorId(competitorId);
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
}
