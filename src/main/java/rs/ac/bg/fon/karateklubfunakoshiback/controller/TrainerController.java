/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.karateklubfunakoshiback.auth.CustomAuthenticationManager;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.TrainerDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.exception.ValidationException;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Trainer;
import rs.ac.bg.fon.karateklubfunakoshiback.service.CustomUserDetailsService;
import rs.ac.bg.fon.karateklubfunakoshiback.service.TrainerService;
import rs.ac.bg.fon.karateklubfunakoshiback.utility.JWTUtility;

/**
 *
 * @author Jeks
 */
@RestController
@CrossOrigin
@RequestMapping("/api/trainer")
public class TrainerController {
    @Autowired
    private JWTUtility jwtUtility;
     
    @Autowired
    private TrainerService trainerService;
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    private AuthenticationManager authenticationManager;

    public TrainerController() {
        authenticationManager= new CustomAuthenticationManager();
    }
    
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody Trainer user){
        Response response= new Response();
        try{
            Authentication authentication= authenticationManager.
                    authenticate(new 
                        UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            System.out.println(authentication.getCredentials());
            final UserDetails userDetails= userDetailsService.loadUserByUsername(user.getUsername());
            String token = jwtUtility.generateToken(userDetails);
            Date expirationDate=jwtUtility.extractExpiration(token);
            
            ArrayList<Object> authData=new ArrayList<>();
            authData.add(token);
            authData.add(expirationDate);
            response.setUserDetails(userDetails);
            response.setResponseData(authData);

            return ResponseEntity.ok().body(response);
            
        }catch (Exception e) {
            response.setResponseData(e.getMessage());
            response.setResponseException(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<Response> saveTrainer(@RequestBody TrainerDTO trainer){
        
        Response response= new Response();
//        if (bindingResult.hasErrors()) {
//            StringBuilder errorMessage = new StringBuilder();
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                errorMessage.append(error.getDefaultMessage()).append("; ");
//            }
//            response.setResponseMessage(errorMessage.toString());
//            response.setResponseData(null);
//            response.setResponseException(null);
//            return ResponseEntity.ok().body(response);
//        }
        try {
            Trainer transformerdTrainerObject= 
                    modelMapper.map(trainer, Trainer.class);
            TrainerDTO savedTrainer = modelMapper.map(
                    trainerService.save(transformerdTrainerObject), TrainerDTO.class);
            response.setResponseMessage("You successfully registered!");
            response.setResponseData(savedTrainer);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        
    }
    
    @GetMapping()
    public ResponseEntity<Response> getAllTrainers(){
        Response response= new Response();
        try {
           
            List<TrainerDTO> trainers= trainerService.getAll().stream().map(tr->modelMapper.map(tr, TrainerDTO.class)).collect(Collectors.toList());
            response.setResponseData(trainers);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteTrainer(@PathVariable("id") Long id){
        Response response= new Response();
        
        try{
            trainerService.deleteTrainer(id);
            response.setResponseData("You successffully deleted trainer");
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch( Exception ex){
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Response> getTrainerById(@PathVariable("id") Long id){
        Response response= new Response();
        
        try{
            TrainerDTO trainer= modelMapper.map(trainerService.getById(id), TrainerDTO.class);
            response.setResponseData(trainer);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch(Exception ex){
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
}
