package zj.healthbooster.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import zj.healthbooster.dto.MealDto;
import zj.healthbooster.entity.Meal;
import zj.healthbooster.mapper.MealMapper;
import zj.healthbooster.service.MealService;


/**
 * A controller class that will be used to handle HTTP requests related to the Meal entity.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/meals/") // maps the controller to this partciular endpoint.
public class MealController {

    private final MealService mealService;

    @PostMapping // maps this method to the POST HTTP method.
    public ResponseEntity<MealDto> createMeal(@RequestBody MealDto mealDto) {
        MealDto savedMeal = mealService.createMeal(mealDto);
        return new ResponseEntity<>(savedMeal, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // maps this method to the GET HTTP method, with id being specified by the user.
    public ResponseEntity<MealDto> getMealById(@PathVariable int id) {
        MealDto retrievedMeal = mealService.getMeal(id);
        return new ResponseEntity<>(retrievedMeal, HttpStatus.CREATED);
    }

    @GetMapping("/") // maps this method to the GET HTTP method.
    public ResponseEntity<List<MealDto>> getAllMeals() {
        List<Meal> retrievedMeals = mealService.fetchAllMeals();
        List<MealDto> transformedMeals = retrievedMeals.stream().map(e -> MealMapper.mapToMealDto(e)).collect(Collectors.toList());
        // return new ResponseEntity<>(transformedMeals, HttpStatus.OK);
        return ResponseEntity.ok(transformedMeals);
    }

    @PutMapping("/{id}") // maps this method to the PUT HTTP method, with id being specified by the user.
    public ResponseEntity<MealDto> updateMeal(@PathVariable int id, @RequestBody MealDto mealDto) {
        MealDto updatedMeal = mealService.updateMeal(mealDto, id);
        return ResponseEntity.ok(updatedMeal);
    }

    @DeleteMapping("/{id}") // maps this method to the DELETE HTTP method, with id being specified by the user.
    public ResponseEntity<String> deleteMeal(@PathVariable int id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok("Meal deleted successfully with ID: " + id);
    }

}
