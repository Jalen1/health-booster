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
@Table(name="meal", schema="hb") // must specify the schema and the name of the table the entity will be mapped to.
public class Meal {

    @Id // specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int meal_id;

    @Column(name="meal_name") // must specify the column in the table that corresponds to each field.
    private String meal_name;

    @Column(name="calories")
    private int calories;

    @Column(name="servings")
    private int servings;

    @Column(name="session_id")
    private int session_id;
}
