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
import rs.ac.bg.fon.karateklubfunakoshiback.exception.UserNotFoundException;
import rs.ac.bg.fon.karateklubfunakoshiback.exception.ValidationException;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Trainer;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.TrainerRepository;

/**
 *
 * @author Jeks
 */
@Service
public class TrainerService {
    
    @Autowired
    private TrainerRepository trainerRepository;
    
    

    public Trainer login(String username, String password) throws UserNotFoundException, Exception{
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
        try{
            if(username==null || username.isEmpty()){
                throw new ValidationException("Username cant be null!");
            }
            if(password == null || password.isEmpty()){
                throw new ValidationException("Password cant be null!");
            }
            Trainer dbTrainer= trainerRepository.login(username, password);
            em.getTransaction().commit();
            if(dbTrainer== null){
                throw new UserNotFoundException("Invalid username or password");
            }
            return dbTrainer;
        }catch(Exception ex){
            em.getTransaction().rollback();
            throw ex;
        } finally{
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
        
    }
    public Trainer save(Trainer trainer){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            Trainer dbResult = trainerRepository.save(trainer);
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
    
    public List<Trainer> getAll(){
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            List<Trainer> dbResult = trainerRepository.getAll();
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

    public void deleteTrainer(Long id) {
       EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            trainerRepository.delete(id);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }

    public Trainer getById(Long id) {
       EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        em.getTransaction().begin();
         try {

            Trainer trainer=trainerRepository.getById(id);
            em.getTransaction().commit();
            return trainer;
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
