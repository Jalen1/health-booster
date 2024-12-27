package zj.healthbooster.mapper;

import zj.healthbooster.dto.SessionDto;
import zj.healthbooster.entity.Session;

/**
 * A class that will be used to map Session entities to SessionDto objects and vice versa.
 */
public class SessionMapper {

    /**
     * Maps a given Session object to a Session Data Transfer Object (DTO).
     * @param a an Session object.
     * @return an Session Data Transfer Object with identical values as the given Session.
     */
    public static SessionDto mapToSessionDto(Session a) {
        return new SessionDto(a.getSession_id(),
                                a.getSession_date(),
                                a.getFk_user(),
                                a.getNet_calories(),
                                a.isMet_goal(),
                                a.getSession_weight());
    }

    /**
     * Maps a given SessionDto object to an Session Object.
     * @param adto an Session Data Transfer Object.
     * @return an Session with identical values as the given Session Data Transfer Object.
     */
    public static Session mapDtoToSession(SessionDto adto) {
        return new Session(adto.getSession_id(),
                            adto.getSession_date(),
                            adto.getFk_user(),
                            adto.getNet_calories(),
                            adto.isMet_goal(),
                            adto.getSession_weight());
    }
}