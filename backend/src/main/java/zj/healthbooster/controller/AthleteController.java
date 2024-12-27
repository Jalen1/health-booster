package zj.healthbooster.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import zj.healthbooster.dto.AthleteDto;
import zj.healthbooster.entity.Athlete;
import zj.healthbooster.mapper.AthleteMapper;
import zj.healthbooster.service.AthleteService;


/**
 * A controller class that will be used to handle HTTP requests related to the Athlete entity.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/athletes/") // maps the controller to this partciular endpoint.
public class AthleteController {

    private final AthleteService athleteService;

    @PostMapping // maps this method to the POST HTTP method.
    public ResponseEntity<AthleteDto> createAthlete(@RequestBody AthleteDto athleteDto) {
        AthleteDto savedAthlete = athleteService.createAthlete(athleteDto);
        return new ResponseEntity<>(savedAthlete, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // maps this method to the GET HTTP method, with id being specified by the user.
    public ResponseEntity<AthleteDto> getAthleteById(@PathVariable int id) {
        AthleteDto retrievedAthlete = athleteService.getAthlete(id);
        return new ResponseEntity<>(retrievedAthlete, HttpStatus.CREATED);
    }

    @GetMapping("/") // maps this method to the GET HTTP method.
    public ResponseEntity<List<AthleteDto>> getAllAthletes() {
        List<Athlete> retrievedAthletes = athleteService.fetchAllAthletes();
        List<AthleteDto> transformedAthletes = retrievedAthletes.stream().map(e -> AthleteMapper.mapToAthleteDto(e)).collect(Collectors.toList());
        // return new ResponseEntity<>(transformedAthletes, HttpStatus.OK);
        return ResponseEntity.ok(transformedAthletes);
    }

    @PutMapping("/{id}") // maps this method to the PUT HTTP method, with id being specified by the user.
    public ResponseEntity<AthleteDto> updateAthlete(@PathVariable int id, @RequestBody AthleteDto athleteDto) {
        AthleteDto updatedAthlete = athleteService.updateAthlete(athleteDto, id);
        return ResponseEntity.ok(updatedAthlete);
    }

    @DeleteMapping("/{id}") // maps this method to the DELETE HTTP method, with id being specified by the user.
    public ResponseEntity<String> deleteAthlete(@PathVariable int id){
        athleteService.deleteAthlete(id);
        return ResponseEntity.ok("Athlete deleted successfully with ID: " + id);
    }

}
