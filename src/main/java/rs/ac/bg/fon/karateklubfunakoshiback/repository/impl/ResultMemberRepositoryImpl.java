/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.model.ResultMember;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.ResultMemberRepository;

/**
 *
 * @author Jeks
 */
@Repository
public class ResultMemberRepositoryImpl implements ResultMemberRepository{

    @Override
    public List<ResultMember> getAll() {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        return em.createQuery("select r from ResultMember r").getResultList();

    }

    @Override
    public ResultMember save(ResultMember result) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.persist(result);
        return result;
    }

    @Override
    public ResultMember update(ResultMember result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ResultMember> getAllByCompetitionId(Long id) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        return em.createQuery("select r from ResultMember r where r.competition.id = :id").setParameter("id", id).getResultList();

    }
    
}
