/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository;

import rs.ac.bg.fon.karateklubfunakoshiback.model.Competitor;


/**
 *
 * @author Jeks
 */
public interface CompetitorRepository {

     Competitor update(Competitor competitor);

     Competitor save(Competitor competitor);

}
