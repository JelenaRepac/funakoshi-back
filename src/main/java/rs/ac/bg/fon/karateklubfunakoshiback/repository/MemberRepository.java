/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.repository;

import java.util.List;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Member;

/**
 *
 * @author Jeks
 */
public interface MemberRepository {
    
    List<Member> getAll();
    
    Member getByCompetitorId(Long id);
    
     void deleteMember(Long id);

     Member save(Member member);

     Member getById(Long id);

    Member update(Member member);
}
