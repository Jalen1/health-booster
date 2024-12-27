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
 * This class represents the Session entity that will be stored in the connected database.
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name="session", schema="hb") // must specify the schema and the name of the table the entity will be mapped to.
public class Session {

    @Id // specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int session_id;

    @Column(name="session_date") // must specify the column in the table that corresponds to each field.
    private java.sql.Date session_date;

    @Column(name="fk_user")
    private int fk_user;

    @Column(name="net_calories")
    private int net_calories;

    @Column(name="met_goal")
    private boolean met_goal;

    @Column(name="session_weight")
    private float session_weight;
}
