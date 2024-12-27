package zj.healthbooster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zj.healthbooster.entity.Workout;

/**
 * This interface extends JpaRepository, which provides basic CRUD operations for entities in our connected Database.
 */
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {}