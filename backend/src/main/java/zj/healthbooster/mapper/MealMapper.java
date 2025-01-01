package zj.healthbooster.mapper;

import zj.healthbooster.dto.MealDto;
import zj.healthbooster.entity.Meal;

/**
 * A class that will be used to map Meal entities to MealDto objects and vice versa.
 */
public class MealMapper {

    /**
     * Maps a given Meal object to a Meal Data Transfer Object (DTO).
     * @param a Meal object.
     * @return a Meal Data Transfer Object with identical values as the given Meal.
     */
    public static MealDto mapToMealDto(Meal a) {
        return new MealDto(a.getMeal_id(),
                                a.getMeal_name(),
                                a.getCalories(),
                                a.getServings(),
                                a.getSession_id());
    }

    /**
     * Maps a given MealDto object to an Meal Object.
     * @param adto an Meal Data Transfer Object.
     * @return an Meal with identical values as the given Meal Data Transfer Object.
     */
    public static Meal mapDtoToMeal(MealDto adto) {
        return new Meal(adto.getMeal_id(),
                            adto.getMeal_name(),
                            adto.getCalories(),
                            adto.getServings(),
                            adto.getSession_id());
    }
}