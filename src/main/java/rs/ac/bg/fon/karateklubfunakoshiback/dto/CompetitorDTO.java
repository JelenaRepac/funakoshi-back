/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Category;
import rs.ac.bg.fon.karateklubfunakoshiback.model.ClassCategory;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Discipline;

/**
 *
 * @author Jeks
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitorDTO {
    
    private Long id;
    private Category category;
    private Discipline discipline;
    private ClassCategory classCategory;
    private Double medals;
    private Double goldMedals;
    private Double silverMedals;
    private Double bronzeMedals;
}
