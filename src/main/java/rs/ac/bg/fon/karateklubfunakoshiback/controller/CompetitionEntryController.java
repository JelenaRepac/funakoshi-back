/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.CompetitionDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.CompetitionEntryDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.Competition;
import rs.ac.bg.fon.karateklubfunakoshiback.model.CompetitionEntry;
import rs.ac.bg.fon.karateklubfunakoshiback.service.CompetitionEntryService;

/**
 *
 * @author Jeks
 */
@Controller
@CrossOrigin
@RequestMapping("api/competitionEntries")
public class CompetitionEntryController {

    @Autowired
    private CompetitionEntryService competitionEntryService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping()
    public ResponseEntity<Response> saveCompetitionEntry(@RequestBody CompetitionEntryDTO competitionEntry) {
        Response response= new Response();
        try {
            CompetitionEntry transformedCompetitionEntryObject =
                    modelMapper.map(competitionEntry, CompetitionEntry.class);
            CompetitionEntryDTO savedCompetitionEntry= modelMapper.map(
                    competitionEntryService.save(transformedCompetitionEntryObject), CompetitionEntryDTO.class);
            response.setResponseData(savedCompetitionEntry);
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

