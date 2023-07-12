package rs.ac.bg.fon.karateklubfunakoshiback.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.exception.UserNotFoundException;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Trainer;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.TrainerRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private TrainerRepository trainerRepository;
    
    
    CustomUserDetailsService(){
      
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        if(!em.getTransaction().isActive())
            em.getTransaction().begin();
        try {
            Trainer t=trainerRepository.findByUsername(username);
            em.getTransaction().commit();
            return new User(t.getUsername(), t.getPassword(), new ArrayList<>());
        } catch (UserNotFoundException e) {
            em.getTransaction().rollback();
            throw new UsernameNotFoundException("Wrong credentials. User with that username and password doesn't exists!");
        }
        finally {
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }


    }
}
