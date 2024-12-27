package zj.healthbooster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zj.healthbooster.entity.Session;

/**
 * This interface extends JpaRepository, which provides basic CRUD operations for entities in our connected Database.
 */
public interface SessionRepository extends JpaRepository<Session, Integer> {}