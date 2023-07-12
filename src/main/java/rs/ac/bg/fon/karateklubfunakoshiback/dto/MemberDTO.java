/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.dto;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Belt;
import rs.ac.bg.fon.karateklubfunakoshiback.model.City;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competitor;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Gender;
import rs.ac.bg.fon.karateklubfunakoshiback.model.MembershipFee;

/**
 *
 * @author Jeks
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    
    private Long id;
    @NotBlank(message = "Firstname can't be empty.")  
    private String name;
    @NotBlank(message = "Lastname can't be empty.")  
    private String lastname;
    private Date birthday;
    private String mothersName;
    private String fathersName;
    private String adress;
    private City city;
    private Date dateOfMembership;
    private Belt belt;
    private Gender gender;
    private Double totalDebt;
    private List<MembershipFee> membershipFees;
    private Competitor competitor;
}
