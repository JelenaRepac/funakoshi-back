/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;
import java.util.List;
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
@Table(name = "competition", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "date", "competition_hall"})
})
public class Competition {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "competition_hall")
    private String competitionHall;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    
    @OneToMany(mappedBy = "competition")
    @JsonIgnore
    private List<ResultMember> resultMember;
    
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<ResultTeam> resultTeams;
}
