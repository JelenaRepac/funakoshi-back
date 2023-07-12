/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
*
 * @author Jeks
 */
@SpringBootApplication
public class KarateKlubFunakoshiBackApplication {

  
    public static void main(String[] args) {
        SpringApplication.run(KarateKlubFunakoshiBackApplication.class, args);
    }
    
     
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    


}
