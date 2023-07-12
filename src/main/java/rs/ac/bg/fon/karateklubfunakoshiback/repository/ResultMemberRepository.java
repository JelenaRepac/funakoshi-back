/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository;

import java.util.List;
import rs.ac.bg.fon.karateklubfunakoshiback.model.ResultMember;

/**
 *
 * @author Jeks
 */
public interface ResultMemberRepository {
    
    List<ResultMember> getAll();

    List<ResultMember> getAllByCompetitionId(Long id); 
     
    public ResultMember save(ResultMember result);

    ResultMember update(ResultMember result);
    
    
}
