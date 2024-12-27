package zj.healthbooster.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 *  A Data Transfer Object (DTO) that will be used to transfer data between the controller and the service layer.
 *  This class will be used to represent an Session entity in a format that can be easily converted to JSON.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {
    private int session_id;

    private java.sql.Date session_date;
    private int fk_user;
    private int net_calories;
    private boolean met_goal;
    private float session_weight;


}
