package zj.healthbooster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import zj.healthbooster.dto.WorkoutDto;
import zj.healthbooster.entity.Workout;
import zj.healthbooster.mapper.WorkoutMapper;
import zj.healthbooster.repository.WorkoutRepository;

/**
 * An implementation of the service layer that will be invoked by the controller when requests are
 * made to perform CRUD operations on the Workout entity.
 */
@Service // Specifies that this class provides services for the Workout entity.
@AllArgsConstructor
public class WorkoutService {

    @Autowired
    private final WorkoutRepository workoutRepository; // injects the WorkoutRepository dependency.

    /**
     * Creates and saves an Workout entity to the repository.
     * @param workout an Workout object representing a session of the application
     * @return the Workout that was saved
     */
    public WorkoutDto createWorkout(WorkoutDto workoutDto) {
        Workout workoutToBeSaved = WorkoutMapper.mapDtoToWorkout(workoutDto);
        Workout savedWorkout = workoutRepository.save(workoutToBeSaved);

        return WorkoutMapper.mapToWorkoutDto(savedWorkout);
    }

    /**
     * Fetches an Workout entity from the repository by its ID.
     * @param workoutID The ID of the Workout to be fetched.
     * @return the Workout object with the specified ID, or null if it does not exist.
     */
    public WorkoutDto getWorkout(int workoutID) {
        Workout res = workoutRepository.findById(workoutID).get();
        return WorkoutMapper.mapToWorkoutDto(res);
    }

    /**
     * Fetches all Workout entities from the repository.
     * @return a List of Workout objects
     */
    public List<Workout> fetchAllWorkouts(){
        return workoutRepository.findAll();
    }

    /**
     * Fetches an Workout entity from the repository by its ID, and updates its fields with the
     * values of the provided Workout object.
     * @param workout the Workout object containing the updated values.
     * @param workoutID the ID of the Workout object to be updated.
     */
    public WorkoutDto updateWorkout(WorkoutDto workoutDto, int workoutID) {

        Workout existingWorkout = workoutRepository.findById(workoutID).get();

        existingWorkout.setWorkout_name(workoutDto.getWorkout_name());
        existingWorkout.setDuration(workoutDto.getDuration());
        existingWorkout.setCalories_burned(workoutDto.getCalories_burned());
        existingWorkout.setSession_id(workoutDto.getSession_id());

        workoutRepository.save(existingWorkout);

        return WorkoutMapper.mapToWorkoutDto(existingWorkout);
    
    }

    /**
     * Deletes an Workout entity from the repository by its ID.
     * @param workoutID the ID of the Workout to be deleted.
     */
    public void deleteWorkout(int workoutID) {
        workoutRepository.deleteById(workoutID);
    }

}