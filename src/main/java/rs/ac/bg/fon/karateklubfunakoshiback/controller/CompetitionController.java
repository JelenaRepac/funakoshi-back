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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.CompetitionDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competition;
import rs.ac.bg.fon.karateklubfunakoshiback.service.CompetitionService;

/**
 *
 * @author Jeks
 */
@RestController
@RequestMapping("api/competition")
@CrossOrigin
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private ModelMapper modelMapper;



    @GetMapping
    @CrossOrigin
    public ResponseEntity<Response> getAll(){
        Response response= new Response();
        try{
            List<CompetitionDTO> competitions = competitionService.getAll().stream().
                    map(competition -> modelMapper.map(competition, CompetitionDTO.class)).
                    collect(Collectors.toList());
            response.setResponseData(competitions);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);

        }catch(Exception ex){
            response.setResponseData(null);
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Response> deleteCompetition(@PathVariable("id") Long id){
        Response response= new Response();
        try{
            competitionService.deleteCompetition(id);

            response.setResponseData("You successfully deleted competition!");
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);

        }catch(Exception ex){
            response.setResponseData(null);
            response.setResponseException(ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @PostMapping()
    public ResponseEntity<Response> saveCompetition(@RequestBody CompetitionDTO competition) {
        Response response= new Response();
        try {
            Competition transformedCompetitionObject =
                    modelMapper.map(competition, Competition.class);
            CompetitionDTO savedCompetition= modelMapper.map(
                    competitionService.save(transformedCompetitionObject), CompetitionDTO.class);
            response.setResponseData(savedCompetition);
            response.setResponseException(null);
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            response.setResponseData(null);
            System.out.println(e.getMessage());
            response.setResponseException(e);
            return ResponseEntity.ok().body(response);
        }
    }

    @PutMapping()
    public ResponseEntity<Response> updateCompetition(@RequestBody CompetitionDTO competitionDTO) {

        Response response = new Response();
        try {
            Competition savedCompetition = competitionService.update(modelMapper.map(competitionDTO, Competition.class));
            response.setResponseData(savedCompetition);
            response.setResponseException(null);
            return ResponseEntity.status(HttpStatus.OK).body(response);


        } catch (Exception ex) {
            response.setResponseData(null);
            response.setResponseException(ex);
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
