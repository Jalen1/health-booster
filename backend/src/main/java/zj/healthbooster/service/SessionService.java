package zj.healthbooster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import zj.healthbooster.dto.SessionDto;
import zj.healthbooster.entity.Session;
import zj.healthbooster.mapper.SessionMapper;
import zj.healthbooster.repository.SessionRepository;

/**
 * An implementation of the service layer that will be invoked by the controller when requests are
 * made to perform CRUD operations on the Session entity.
 */
@Service // Specifies that this class provides services for the Session entity.
@AllArgsConstructor
public class SessionService {

    @Autowired
    private final SessionRepository sessionRepository; // injects the SessionRepository dependency.

    /**
     * Creates and saves an Session entity to the repository.
     * @param session an Session object representing a session of the application
     * @return the Session that was saved
     */
    public SessionDto createSession(SessionDto sessionDto) {
        Session sessionToBeSaved = SessionMapper.mapDtoToSession(sessionDto);
        Session savedSession = sessionRepository.save(sessionToBeSaved);

        return SessionMapper.mapToSessionDto(savedSession);
    }

    /**
     * Fetches an Session entity from the repository by its ID.
     * @param sessionID The ID of the Session to be fetched.
     * @return the Session object with the specified ID, or null if it does not exist.
     */
    public SessionDto getSession(int sessionID) {
        Session res = sessionRepository.findById(sessionID).get();
        return SessionMapper.mapToSessionDto(res);
    }

    /**
     * Fetches all Session entities from the repository.
     * @return a List of Session objects
     */
    public List<Session> fetchAllSessions(){
        return sessionRepository.findAll();
    }

    /**
     * Fetches an Session entity from the repository by its ID, and updates its fields with the
     * values of the provided Session object.
     * @param session the Session object containing the updated values.
     * @param sessionID the ID of the Session object to be updated.
     */
    public SessionDto updateSession(SessionDto sessionDto, int sessionID) {

        Session existingSession = sessionRepository.findById(sessionID).get();

        existingSession.setFk_user(sessionDto.getFk_user());
        existingSession.setMet_goal(sessionDto.isMet_goal());
        existingSession.setNet_calories(sessionDto.getNet_calories());
        existingSession.setSession_date(sessionDto.getSession_date());
        existingSession.setSession_weight(sessionDto.getSession_weight());

        sessionRepository.save(existingSession);

        return SessionMapper.mapToSessionDto(existingSession);
    
    }

    /**
     * Deletes an Session entity from the repository by its ID.
     * @param sessionID the ID of the Session to be deleted.
     */
    public void deleteSession(int sessionID) {
        sessionRepository.deleteById(sessionID);
    }

}