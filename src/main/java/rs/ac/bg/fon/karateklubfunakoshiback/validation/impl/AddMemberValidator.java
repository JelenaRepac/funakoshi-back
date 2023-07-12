/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.validation.impl;

import rs.ac.bg.fon.karateklubfunakoshiback.exception.ValidationException;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Member;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.MemberRepository;
import rs.ac.bg.fon.karateklubfunakoshiback.repository.impl.MemberRepositoryImpl;
import rs.ac.bg.fon.karateklubfunakoshiback.validation.MemberValidator;

/**
 *
 * @author Jeks
 */
public class AddMemberValidator implements MemberValidator{

    private MemberRepository memberRepository;

    public AddMemberValidator() {
        memberRepository= new MemberRepositoryImpl();
    }
    
    @Override
    public void validate(Object o) throws ValidationException{
//        if(!(o instanceof Member)){
//            throw new ValidationException("Received object is the wrong type!");
//        } else {
//            
//        }
    }
    
}
