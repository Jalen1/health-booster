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
import zj.healthbooster.dto.SessionDto;
import zj.healthbooster.entity.Session;
import zj.healthbooster.mapper.SessionMapper;
import zj.healthbooster.service.SessionService;


/**
 * A controller class that will be used to handle HTTP requests related to the Session entity.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/sessions/") // maps the controller to this partciular endpoint.
public class SessionController {

    private final SessionService sessionService;

    @PostMapping // maps this method to the POST HTTP method.
    public ResponseEntity<SessionDto> createSession(@RequestBody SessionDto sessionDto) {
        SessionDto savedSession = sessionService.createSession(sessionDto);
        return new ResponseEntity<>(savedSession, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // maps this method to the GET HTTP method, with id being specified by the user.
    public ResponseEntity<SessionDto> getSessionById(@PathVariable int id) {
        SessionDto retrievedSession = sessionService.getSession(id);
        return new ResponseEntity<>(retrievedSession, HttpStatus.CREATED);
    }

    @GetMapping("/") // maps this method to the GET HTTP method.
    public ResponseEntity<List<SessionDto>> getAllSessions() {
        List<Session> retrievedSessions = sessionService.fetchAllSessions();
        List<SessionDto> transformedSessions = retrievedSessions.stream().map(e -> SessionMapper.mapToSessionDto(e)).collect(Collectors.toList());
        // return new ResponseEntity<>(transformedSessions, HttpStatus.OK);
        return ResponseEntity.ok(transformedSessions);
    }

    @PutMapping("/{id}") // maps this method to the PUT HTTP method, with id being specified by the user.
    public ResponseEntity<SessionDto> updateSession(@PathVariable int id, @RequestBody SessionDto sessionDto) {
        SessionDto updatedSession = sessionService.updateSession(sessionDto, id);
        return ResponseEntity.ok(updatedSession);
    }

    @DeleteMapping("/{id}") // maps this method to the DELETE HTTP method, with id being specified by the user.
    public ResponseEntity<String> deleteSession(@PathVariable int id){
        sessionService.deleteSession(id);
        return ResponseEntity.ok("Session deleted successfully with ID: " + id);
    }

}
