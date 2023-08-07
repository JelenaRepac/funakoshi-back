/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.CompetitorDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competitor;
import rs.ac.bg.fon.karateklubfunakoshiback.service.CompetitorService;

/**
 *
 * @author Jeks
 */
@RestController
@RequestMapping("api/competitor")
@CrossOrigin
public class CompetitorController {

    @Autowired
    private CompetitorService competitorService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping()
    @CrossOrigin
    public ResponseEntity<Response> saveCompetitor(@RequestBody CompetitorDTO competitorDTO) {
        Response response= new Response();
        try {
            Competitor transformedCompetitorObject =
                    modelMapper.map(competitorDTO, Competitor.class);
            CompetitorDTO savedCompetitor= modelMapper.map(
                    competitorService.save(transformedCompetitorObject), CompetitorDTO.class);
            response.setResponseData(savedCompetitor);
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
    @CrossOrigin
    public ResponseEntity<Response> updateCompetitor(@RequestBody CompetitorDTO competitorDTO) {

        Response response = new Response();
        try {
            Competitor savedCompetitor = competitorService.update(modelMapper.map(competitorDTO, Competitor.class));
            System.out.println(savedCompetitor+ "TAKMICAR");
            response.setResponseData(savedCompetitor);
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
