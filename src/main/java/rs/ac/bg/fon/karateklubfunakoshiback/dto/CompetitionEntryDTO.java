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
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competition;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competitor;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Medal;

/**
 *
 * @author Jeks
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionEntryDTO {

    private Long id;
    private Competition competition;
    private Competitor competitor;
}
