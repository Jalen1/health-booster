package zj.healthbooster.mapper;

import zj.healthbooster.dto.AthleteDto;
import zj.healthbooster.entity.Athlete;

/**
 * A class that will be used to map Athlete entities to AthleteDto objects and vice versa.
 */
public class AthleteMapper {

    /**
     * Maps a given Athlete object to a Athlete Data Transfer Object (DTO).
     * @param a an Athlete object.
     * @return an Athlete Data Transfer Object with identical values as the given Athlete.
     */
    public static AthleteDto mapToAthleteDto(Athlete a) {
        return new AthleteDto(a.getUser_id(),
                                a.getFirst_name(),
                                a.getLast_name(),
                                a.getStart_weight(),
                                a.getCurrent_weight(),
                                a.getGoal_weight(),
                                a.getEmail(),
                                a.getPassword());
    }

    /**
     * Maps a given AthleteDto object to an Athlete Object.
     * @param adto an Athlete Data Transfer Object.
     * @return an Athlete with identical values as the given Athlete Data Transfer Object.
     */
    public static Athlete mapDtoToAthlete(AthleteDto adto) {
        return new Athlete(adto.getUser_id(),
                            adto.getFirst_name(),
                            adto.getLast_name(),
                            adto.getStart_weight(),
                            adto.getCurrent_weight(),
                            adto.getGoal_weight(),
                            adto.getEmail(),
                            adto.getPassword());

    }
}