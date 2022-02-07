package todolistApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolistApi.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    void deleteAllById(Integer id);
}
