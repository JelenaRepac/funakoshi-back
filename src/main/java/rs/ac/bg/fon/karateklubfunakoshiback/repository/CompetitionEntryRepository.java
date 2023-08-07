/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository;

import rs.ac.bg.fon.karateklubfunakoshiback.model.CompetitionEntry;

import java.util.List;


/**
 *
 * @author Jeks
 */
public interface CompetitionEntryRepository {

     CompetitionEntry save(CompetitionEntry competitionEntry);

     List<CompetitionEntry> getAllByCompetitionId(Long id);


}
