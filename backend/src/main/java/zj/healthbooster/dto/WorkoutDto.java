package zj.healthbooster.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  A Data Transfer Object (DTO) that will be used to transfer data between the controller and the service layer.
 *  This class will be used to represent an Athlete entity in a format that can be easily converted to JSON.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {
    private int workout_id;
    private String workout_name;
    private int duration;
    private int calories_burned;
    private int session_id;
}
