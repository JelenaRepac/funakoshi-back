/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class TrainerDTO {
    
    private Long id;
    @NotBlank(message = "Username can't be empty.")
    @Size(min = 4, message = "Username must contain at least 4 characters.")
    private String username;
    @NotBlank(message = "Password can't be empty.")
    @Size(min = 4, message = "Password must contain at least 8 characters.")
    private String password;
    @Email(message = "Email should be valid.")
    private String email;
    @NotBlank(message = "Firstname can't be empty.")
    private String firstname;
    @NotBlank(message = "Lastname can't be empty.")  
    private String lastname;
}
