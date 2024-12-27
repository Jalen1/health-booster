package zj.healthbooster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import zj.healthbooster.dto.MealDto;
import zj.healthbooster.entity.Meal;
import zj.healthbooster.mapper.MealMapper;
import zj.healthbooster.repository.MealRepository;

/**
 * An implementation of the service layer that will be invoked by the controller when requests are
 * made to perform CRUD operations on the Meal entity.
 */
@Service // Specifies that this class provides services for the Meal entity.
@AllArgsConstructor
public class MealService {

    @Autowired
    private final MealRepository mealRepository; // injects the MealRepository dependency.

    /**
     * Creates and saves an Meal entity to the repository.
     * @param meal an Meal object representing a session of the application
     * @return the Meal that was saved
     */
    public MealDto createMeal(MealDto mealDto) {
        Meal mealToBeSaved = MealMapper.mapDtoToMeal(mealDto);
        Meal savedMeal = mealRepository.save(mealToBeSaved);

        return MealMapper.mapToMealDto(savedMeal);
    }

    /**
     * Fetches an Meal entity from the repository by its ID.
     * @param mealID The ID of the Meal to be fetched.
     * @return the Meal object with the specified ID, or null if it does not exist.
     */
    public MealDto getMeal(int mealID) {
        Meal res = mealRepository.findById(mealID).get();
        return MealMapper.mapToMealDto(res);
    }

    /**
     * Fetches all Meal entities from the repository.
     * @return a List of Meal objects
     */
    public List<Meal> fetchAllMeals(){
        return mealRepository.findAll();
    }

    /**
     * Fetches an Meal entity from the repository by its ID, and updates its fields with the
     * values of the provided Meal object.
     * @param meal the Meal object containing the updated values.
     * @param mealID the ID of the Meal object to be updated.
     */
    public MealDto updateMeal(MealDto mealDto, int mealID) {

        Meal existingMeal = mealRepository.findById(mealID).get();

        existingMeal.setMeal_name(mealDto.getMeal_name());
        existingMeal.setCalories(mealDto.getCalories());
        existingMeal.setServings(mealDto.getServings());
        existingMeal.setSession_id(mealDto.getSession_id());

        mealRepository.save(existingMeal);

        return MealMapper.mapToMealDto(existingMeal);
    
    }

    /**
     * Deletes an Meal entity from the repository by its ID.
     * @param mealID the ID of the Meal to be deleted.
     */
    public void deleteMeal(int mealID) {
        mealRepository.deleteById(mealID);
    }

}