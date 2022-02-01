package todolistApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todolistApi.Entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
