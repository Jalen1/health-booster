package zj.healthbooster.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents the Athlete entity that will be stored in the connected database.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name="workout", schema="hb") // must specify the schema and the name of the table the entity will be mapped to.
public class Workout {

    @Id // specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workout_id;

    @Column(name="workout_name") // must specify the column in the table that corresponds to each field.
    private String workout_name;

    @Column(name="duration")
    private int duration;

    @Column(name="calories_burned")
    private int calories_burned;

    @Column(name="session_id")
    private int session_id;
}
