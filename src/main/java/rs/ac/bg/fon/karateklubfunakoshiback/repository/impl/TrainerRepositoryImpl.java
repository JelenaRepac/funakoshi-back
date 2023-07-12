/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.exception.UserNotFoundException;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Trainer;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.TrainerRepository;

/**
 *
 * @author Jeks
 */
@Repository
public class TrainerRepositoryImpl  implements TrainerRepository{

    @Override
    public Trainer save(Trainer trainer) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.persist(trainer);
        return trainer;
    }

    @Override
    public List<Trainer> getAll() {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        List<Trainer> dbResult = em.createQuery("select t from Trainer t")
                .getResultList();
        return dbResult;
    }

    @Override
    public void delete(Long id) {
      EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
      Trainer trainerDb= em.find(Trainer.class, id);
      em.remove(trainerDb);
    }

    @Override
    public Trainer getById(Long id) {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        return em.find(Trainer.class, id);
    }

    
    @Override
    public Trainer login(String username, String password) throws UserNotFoundException {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        List<Trainer> dbResult= 
                em.createQuery("select t from Trainer t where t.username LIKE :valueUsername and t.password LIKE :valuePassword").
                        setParameter("valueUsername", username).
                        setParameter("valuePassword", password).
                        getResultList();
        if(dbResult.isEmpty()){
            throw new UserNotFoundException("Wrong credentials.");
        }
        return dbResult.get(0);
        
    }

    @Override
    public Trainer findByUsername(String username) throws UserNotFoundException {
       EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
       List<Trainer> dbResult= 
               em.createQuery("select t from Trainer t where t.username LIKE :valueUsername").
                       setParameter("valueUsername", username).
                       getResultList();
       if(dbResult.isEmpty()){
            throw new UserNotFoundException("Invalid username.");
        }
       return dbResult.get(0);       
    }
    
}
