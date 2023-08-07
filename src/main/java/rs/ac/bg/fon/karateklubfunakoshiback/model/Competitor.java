/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jeks
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "competitor")
public class Competitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Discipline discipline;
    @Enumerated (EnumType.STRING)
    @Column(name = "class_category")
    private ClassCategory classCategory;
    private Double medals;
    @Column(name = "gold_medals")
    private Double goldMedals;
    @Column(name = "silver_medals")
    private Double silverMedals;
    @Column(name = "bronze_medals")
    private Double bronzeMedals;
    
   
    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;
//
//
//    @OneToMany(mappedBy = "competitor" ,cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<ResultMember> resultMember;
//
    
    
    
}
