/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Member;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.MemberRepository;

/**
 *
 * @author Jeks
 */
@Repository
public class MemberRepositoryImpl implements MemberRepository{

    @Override
    public List<Member> getAll() {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
       return em.createQuery("select m from Member m").getResultList();
    }

    @Override
    public void deleteMember(Long id) {
       EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
       Member dbMember= em.find(Member.class,id);
       em.remove(dbMember);
    }

    @Override
    public Member save(Member member) {
       EntityManager em= EntityManagerProvider.getInstance().getEntityManager();   
       em.persist(member);
       return member;
    }

    @Override
    public Member getById(Long id) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        return em.find(Member.class,id);
    }

    @Override
    public Member update(Member member) {
        EntityManager em=EntityManagerProvider.getInstance().getEntityManager();
        Member dbMember = em.find(Member.class, member.getId());
        if(dbMember==null){
            System.out.println("Member doesnt exists!");
        }
        else{
            Member updatedMember = em.merge(member);
            System.out.println(updatedMember);
            return updatedMember;
        }
        return dbMember;
       
    }

    @Override
    public Member getByCompetitorId(Long id) {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        List<Member> results = em.createQuery("select m from Member m where m.competitor.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();

        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }
    
    
}
