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
@Table(name = "member", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "lastname", "birthday"})
})
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private Date birthday;
    @Column(name = "mothers_name")
    private String mothersName;
    @Column(name = "fathers_name")
    private String fathersName;
    private String adress;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @Column(name = "date_of_membership")
    private Date dateOfMembership;
    @Enumerated(EnumType.STRING)
    private Belt belt;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "total_debt")
    private Double totalDebt;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<MembershipFee> membershipFees;
    
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name="competitor_id",
            referencedColumnName = "id")
    private Competitor competitor;
    
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", mothersName='" + mothersName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", adress='" + adress + '\'' +
                ", city=" + (city != null ? city.getId() : null) +
                ", dateOfMembership=" + dateOfMembership +
                ", belt=" + belt +
                ", gender=" + gender +
                ", totalDebt=" + totalDebt +
                '}';
    }


}
