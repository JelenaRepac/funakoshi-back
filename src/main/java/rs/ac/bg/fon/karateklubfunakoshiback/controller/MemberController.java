/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.MemberDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.service.MemberService;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Member;
/**
 *
 * @author Jeks
 */
@RestController
@CrossOrigin
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping
    @CrossOrigin
    public ResponseEntity<Response> getAllMembers(){
        Response response= new Response();
        try {
            
            List<MemberDTO> members = memberService.getAll().stream().map(member -> modelMapper.map(member, MemberDTO.class))
                    .collect(Collectors.toList());
            response.setResponseData(members);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.ok().body(response);
        }
    }
    
    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Response> deleteMember(@PathVariable("id") Long id){
        Response response= new Response();
        
        try{
            memberService.deleteMember(id);
            response.setResponseData("You successffully deleted member");
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }catch( Exception ex){
            response.setResponseData(null);
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
    @PostMapping
    @CrossOrigin
    public ResponseEntity<Response> saveMember(@Valid @RequestBody MemberDTO member, BindingResult bindingResult){
        Response response= new Response();
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("; ");
            }
            response.setResponseMessage(errorMessage.toString());
            response.setResponseData(null);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        }
        try{
            Member transformedMemberObject =
                    modelMapper.map(member, Member.class);
            MemberDTO savedMember= modelMapper.map(
                    memberService.save(transformedMemberObject), MemberDTO.class);
            response.setResponseData(savedMember);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        } catch( Exception ex){
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.ok().body(response);
        }
        
    }
    
    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Response> getMemberById(@PathVariable("id") Long id){
        Response response= new Response();
        
        try{
            MemberDTO member= modelMapper.map(memberService.getMemberById(id), MemberDTO.class);
            response.setResponseData(member);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);
        } catch( Exception ex){
            response.setResponseData(null);
            System.out.println(ex.getMessage());
            response.setResponseException(ex);
            return ResponseEntity.ok().body(response);
        }
    }
    
     @PutMapping()
    public ResponseEntity<Response> updateMember(@RequestBody MemberDTO memebrDTO) {

        Response response = new Response();
        try {
            Member savedMember = memberService.update(modelMapper.map(memebrDTO, Member.class));
            response.setResponseData(savedMember);
            response.setResponseException(null);
            return ResponseEntity.status(HttpStatus.OK).body(response);


        } catch (Exception ex) {
            response.setResponseData(null);
            response.setResponseException(ex);
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
    @GetMapping("/competitor/id/{id}")
    @CrossOrigin
    public ResponseEntity<Response> getAllMembersByCompetitorId(@PathVariable(name = "id") Long id){
        Response response= new Response();
        try {
            
            MemberDTO member = modelMapper.map(memberService.getAllByCompetitor(id), MemberDTO.class);
            response.setResponseData(member);
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
