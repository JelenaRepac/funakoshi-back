/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.ResultMemberDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.service.ResultMemberService;

/**
 *
 * @author Jeks
 */
@Controller
@CrossOrigin
@RequestMapping("api/memberResult")
public class ResultMemberController {
    
    @Autowired
    private ResultMemberService resultService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping
    @CrossOrigin
    public ResponseEntity<Response> getAllResults(){
        Response response= new Response();
        try {
            
            List<ResultMemberDTO> results = resultService.getAll().stream().map(result -> modelMapper.map(result, ResultMemberDTO.class))
                    .collect(Collectors.toList());
            response.setResponseData(results);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.ok().body(response);
        }
    }
    @GetMapping("/competition/id/{id}")
    @CrossOrigin
    public ResponseEntity<Response> getAllResultsByCompetition(@PathVariable(name="id") Long id){
        Response response= new Response();
        try {
            
            List<ResultMemberDTO> results = resultService.getAllByCompetitionId(id).stream().map(result -> modelMapper.map(result, ResultMemberDTO.class))
                    .collect(Collectors.toList());
            response.setResponseData(results);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.ok().body(response);
        }
    }
}
