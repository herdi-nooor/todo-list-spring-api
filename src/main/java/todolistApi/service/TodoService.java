package todolistApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolistApi.entity.Todo;
import todolistApi.repository.TodoRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> todoList(){
        return repository.findAll();
    }

    public void createTodo(Todo todo){
        repository.save(todo);
    }

    public Optional<Todo> readTodo(Integer id){
        return repository.findById(id);
    }

    public void updateTodo(Integer id, Todo todo){
        Todo todos = repository.findById(id).get();
        todos.setTodo(todo.getTodo());
        todos.setDate(Timestamp.from(Instant.now()));
        repository.save(todos);
    }

    public boolean deleteTodo(Integer id){
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
