package zj.healthbooster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import zj.healthbooster.dto.AthleteDto;
import zj.healthbooster.entity.Athlete;
import zj.healthbooster.mapper.AthleteMapper;
import zj.healthbooster.repository.AthleteRepository;

/**
 * An implementation of the service layer that will be invoked by the controller when requests are
 * made to perform CRUD operations on the Athlete entity.
 */
@Service // Specifies that this class provides services for the Athlete entity.
@AllArgsConstructor
public class AthleteService {

    @Autowired
    private final AthleteRepository athleteRepository; // injects the AthleteRepository dependency.

    /**
     * Creates and saves an Athlete entity to the repository.
     * @param athlete an Athlete object representing a user of the application
     * @return the Athlete that was saved
     */
    public AthleteDto createAthlete(AthleteDto athleteDto) {
        Athlete athleteToBeSaved = AthleteMapper.mapDtoToAthlete(athleteDto);
        Athlete savedAthlete = athleteRepository.save(athleteToBeSaved);

        return AthleteMapper.mapToAthleteDto(savedAthlete);
    }

    /**
     * Fetches an Athlete entity from the repository by its ID.
     * @param athleteID The ID of the Athlete to be fetched.
     * @return the Athlete object with the specified ID, or null if it does not exist.
     */
    public AthleteDto getAthlete(int athleteID) {
        Athlete res = athleteRepository.findById(athleteID).get();
        return AthleteMapper.mapToAthleteDto(res);
    }

    /**
     * Fetches all Athlete entities from the repository.
     * @return a List of Athlete objects
     */
    public List<Athlete> fetchAllAthletes(){
        return athleteRepository.findAll();
    }

    /**
     * Fetches an Athlete entity from the repository by its ID, and updates its fields with the
     * values of the provided Athlete object.
     * @param athlete the Athlete object containing the updated values.
     * @param athleteID the ID of the Athlete object to be updated.
     */
    public AthleteDto updateAthlete(AthleteDto athleteDto, int athleteID) {

        Athlete existingAthlete = athleteRepository.findById(athleteID).get();

        existingAthlete.setFirst_name(athleteDto.getFirst_name());
        existingAthlete.setLast_name(athleteDto.getLast_name());
        existingAthlete.setEmail(athleteDto.getEmail());

        existingAthlete.setStart_weight(athleteDto.getStart_weight());
        existingAthlete.setCurrent_weight(athleteDto.getCurrent_weight());
        existingAthlete.setGoal_weight(athleteDto.getGoal_weight());

        existingAthlete.setPassword(athleteDto.getPassword());
        // existingAthlete.setUser_id(athleteDto.getUser_id());

        athleteRepository.save(existingAthlete);

        return AthleteMapper.mapToAthleteDto(existingAthlete);
    
    }

    /**
     * Deletes an Athlete entity from the repository by its ID.
     * @param athleteID the ID of the Athlete to be deleted.
     */
    public void deleteAthlete(int athleteID) {
        athleteRepository.deleteById(athleteID);
    }

}