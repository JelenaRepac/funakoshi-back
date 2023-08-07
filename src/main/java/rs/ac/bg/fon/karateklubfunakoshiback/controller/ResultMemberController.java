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
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.ResultMemberDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.ResultMember;
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
    @PostMapping()
    public ResponseEntity<Response> saveResultMember(@RequestBody ResultMemberDTO resultMemberDTO) {
        Response response= new Response();
        try {
            ResultMember transformedResultMemberObject =
                    modelMapper.map(resultMemberDTO, ResultMember.class);
            System.out.println(transformedResultMemberObject+"DTO");
            ResultMemberDTO savedResultMember= modelMapper.map(
                    resultService.save(transformedResultMemberObject), ResultMemberDTO.class);
            System.out.println(savedResultMember+"RESULTTT");
            response.setResponseData(savedResultMember);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            response.setResponseData(null);
            System.out.println(e.getMessage());
            response.setResponseException(e);
            return ResponseEntity.ok().body(response);
        }
    }
}
