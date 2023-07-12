/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository;

import java.util.List;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competition;

/**
 *
 * @author Jeks
 */
public interface CompetitionRepository {
    
    List<Competition> getAll();

    public void deleteCompetition(Long id);

    public Competition save(Competition competition);
    
    Competition update(Competition competition);
}
