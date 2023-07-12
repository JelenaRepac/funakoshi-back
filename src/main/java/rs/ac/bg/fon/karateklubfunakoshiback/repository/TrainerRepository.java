/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository;

import java.util.List;
import rs.ac.bg.fon.karateklubfunakoshiback.exception.UserNotFoundException;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Trainer;

/**
 *
 * @author Jeks
 */
public interface TrainerRepository {
    
    Trainer save(Trainer trainer);
    
    List<Trainer> getAll();

    public void delete(Long id);

    public Trainer getById(Long id);
    
    Trainer login(String username, String password) throws UserNotFoundException;
    
    Trainer findByUsername(String username) throws UserNotFoundException;
  
}
