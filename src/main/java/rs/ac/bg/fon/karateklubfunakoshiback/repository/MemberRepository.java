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
    
    Member getAllByCompetitorId(Long id);
    
    public void deleteMember(Long id);

    public Member save(Member member);

    public Member getById(Long id);

    Member update(Member member);
}
