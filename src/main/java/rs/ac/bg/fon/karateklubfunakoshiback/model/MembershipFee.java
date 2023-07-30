/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.model;

import java.sql.Date;
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
@Table(name="membership_fee")
public class MembershipFee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Month month;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    
    @Override
    public String toString() {
        return "MembershipFee{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", member=" + (member != null ? member.getId() : null) +
                '}';
    }
}
