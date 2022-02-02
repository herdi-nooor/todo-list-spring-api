package todolistApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolistApi.entity.Todo;
import todolistApi.repository.TodoRepository;

import java.util.List;
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
        repository.save(todos);
    }
}
