package rs.ac.bg.fon.karateklubfunakoshiback.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import rs.ac.bg.fon.karateklubfunakoshiback.dbconnection.EntityManagerProvider;
import rs.ac.bg.fon.karateklubfunakoshiback.exception.UserNotFoundException;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Trainer;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.TrainerRepository;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.impl.TrainerRepositoryImpl;

public class CustomAuthenticationManager implements AuthenticationManager {
    private TrainerRepository repository;

    public CustomAuthenticationManager(){
        repository=new TrainerRepositoryImpl();

    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        EntityManager em= EntityManagerProvider.getInstance().getEntityManager();
        try {

            em.getTransaction().begin();
            Trainer trainer=repository.login(name, password);
            em.getTransaction().commit();
            return new UsernamePasswordAuthenticationToken(
                    name, password, new ArrayList<>());
        } catch (UserNotFoundException e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        finally{
            em.close();
            EntityManagerProvider.getInstance().closeSession();
        }
    }
}
