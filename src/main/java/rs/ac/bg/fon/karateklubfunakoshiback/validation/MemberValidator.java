/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.validation;

import rs.ac.bg.fon.karateklubfunakoshiback.exception.ValidationException;

/**
 *
 * @author Jeks
 */
public interface MemberValidator {
    
    void validate(Object o) throws ValidationException;
}
