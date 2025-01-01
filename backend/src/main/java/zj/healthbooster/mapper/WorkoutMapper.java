package zj.healthbooster.mapper;

import zj.healthbooster.dto.WorkoutDto;
import zj.healthbooster.entity.Workout;

/**
 * A class that will be used to map Workout entities to WorkoutDto objects and vice versa.
 */
public class WorkoutMapper {

    /**
     * Maps a given Workout object to a Workout Data Transfer Object (DTO).
     * @param a Workout object.
     * @return a Workout Data Transfer Object with identical values as the given Workout.
     */
    public static WorkoutDto mapToWorkoutDto(Workout a) {
        return new WorkoutDto(a.getWorkout_id(),
                                a.getWorkout_name(),
                                a.getDuration(),
                                a.getCalories_burned(),
                                a.getSession_id());
    }

    /**
     * Maps a given WorkoutDto object to an Workout Object.
     * @param adto an Workout Data Transfer Object.
     * @return an Workout with identical values as the given Workout Data Transfer Object.
     */
    public static Workout mapDtoToWorkout(WorkoutDto adto) {
        return new Workout(adto.getWorkout_id(),
                            adto.getWorkout_name(),
                            adto.getDuration(),
                            adto.getCalories_burned(),
                            adto.getSession_id());
    }
}