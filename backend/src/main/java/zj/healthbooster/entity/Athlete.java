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
@Table(name="athlete", schema="hb") // must specify the schema and the name of the table the entity will be mapped to.
public class Athlete {

    @Id // specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(name="first_name") // must specify the column in the table that corresponds to each field.
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="start_weight")
    private float start_weight;

    @Column(name="current_weight")
    private float current_weight;

    @Column(name="goal_weight")
    private float goal_weight;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;
}
