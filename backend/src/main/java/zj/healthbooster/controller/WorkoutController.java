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
import zj.healthbooster.dto.WorkoutDto;
import zj.healthbooster.entity.Workout;
import zj.healthbooster.mapper.WorkoutMapper;
import zj.healthbooster.service.WorkoutService;


/**
 * A controller class that will be used to handle HTTP requests related to the Workout entity.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/workouts/") // maps the controller to this partciular endpoint.
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping // maps this method to the POST HTTP method.
    public ResponseEntity<WorkoutDto> createWorkout(@RequestBody WorkoutDto workoutDto) {
        WorkoutDto savedWorkout = workoutService.createWorkout(workoutDto);
        return new ResponseEntity<>(savedWorkout, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // maps this method to the GET HTTP method, with id being specified by the user.
    public ResponseEntity<WorkoutDto> getWorkoutById(@PathVariable int id) {
        WorkoutDto retrievedWorkout = workoutService.getWorkout(id);
        return new ResponseEntity<>(retrievedWorkout, HttpStatus.CREATED);
    }

    @GetMapping("/") // maps this method to the GET HTTP method.
    public ResponseEntity<List<WorkoutDto>> getAllWorkouts() {
        List<Workout> retrievedWorkouts = workoutService.fetchAllWorkouts();
        List<WorkoutDto> transformedWorkouts = retrievedWorkouts.stream().map(e -> WorkoutMapper.mapToWorkoutDto(e)).collect(Collectors.toList());
        // return new ResponseEntity<>(transformedWorkouts, HttpStatus.OK);
        return ResponseEntity.ok(transformedWorkouts);
    }

    @PutMapping("/{id}") // maps this method to the PUT HTTP method, with id being specified by the user.
    public ResponseEntity<WorkoutDto> updateWorkout(@PathVariable int id, @RequestBody WorkoutDto workoutDto) {
        WorkoutDto updatedWorkout = workoutService.updateWorkout(workoutDto, id);
        return ResponseEntity.ok(updatedWorkout);
    }

    @DeleteMapping("/{id}") // maps this method to the DELETE HTTP method, with id being specified by the user.
    public ResponseEntity<String> deleteWorkout(@PathVariable int id){
        workoutService.deleteWorkout(id);
        return ResponseEntity.ok("Workout deleted successfully with ID: " + id);
    }

}
