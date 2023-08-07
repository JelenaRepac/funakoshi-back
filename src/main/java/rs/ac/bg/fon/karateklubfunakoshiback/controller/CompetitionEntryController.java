/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.karateklubfunakoshiback.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.karateklubfunakoshiback.communication.Response;
import rs.ac.bg.fon.karateklubfunakoshiback.dto.CompetitionEntryDTO;
import rs.ac.bg.fon.karateklubfunakoshiback.model.CompetitionEntry;
import rs.ac.bg.fon.karateklubfunakoshiback.service.CompetitionEntryService;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/competition/id/{id}")
    @CrossOrigin
    public ResponseEntity<Response> getAllEntriesByCompetition(@PathVariable(name="id") Long id){
        Response response= new Response();
        try {

            List<CompetitionEntryDTO> entries = competitionEntryService.getAllByCompetitionId(id).stream().map(entry -> modelMapper.map(entry, CompetitionEntryDTO.class))
                    .collect(Collectors.toList());
            response.setResponseData(entries);
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

