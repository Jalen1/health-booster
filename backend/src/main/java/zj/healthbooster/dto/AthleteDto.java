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
public class AthleteDto {
    private int user_id;

    private String first_name;
    private String last_name;
    private float start_weight;
    private float current_weight;
    private float goal_weight;

    private String email;
    private String password;


}
