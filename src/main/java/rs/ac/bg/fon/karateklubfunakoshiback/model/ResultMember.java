/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.model;

import javax.persistence.*;

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
@Table(name = "result_member", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"medal","competitor_id","category","competiton_id"})
})
public class ResultMember {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Medal medal;
    @ManyToOne
    @JoinColumn(name = "competiton_id")
    private Competition competition;
    @ManyToOne
    @JoinColumn(name = "competitor_id")
    private Competitor competitor;
}
