/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.CityDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.City;
import rs.ac.bg.fon.karateklubfunakoshiback.service.CityService;

/**
 *
 * @author Jeks
 */
@RestController
@CrossOrigin
@RequestMapping("/api/city")
public class CityController {
    
    @Autowired 
    private CityService cityService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping
    @CrossOrigin
    public ResponseEntity<Response> getAll(){
        Response response= new Response();
        
        try{
            List<CityDTO> cities= cityService.getAll().stream().
                    map(city -> modelMapper.map(city, CityDTO.class))
                    .collect(Collectors.toList());
            response.setResponseData(cities);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch(Exception ex){
            response.setResponseData(null);
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Response> getById(@PathVariable("id") Long id){
        Response response= new Response();
        
        try{
            CityDTO city = modelMapper.map(cityService.getById(id), CityDTO.class);
            response.setResponseData(city);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch(Exception ex){
            response.setResponseData(null);
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
