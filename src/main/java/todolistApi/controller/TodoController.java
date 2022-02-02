package todolistApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todolistApi.entity.Todo;
import todolistApi.service.TodoService;
import todolistApi.utill.ApiResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodo(){
        List<Todo> body = service.todoList();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createTodo(@Valid @RequestBody Todo todo){
        if (Objects.nonNull(service.readTodo(todo.getId()))){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "sudah ada"), HttpStatus.CONFLICT);
        }
        service.createTodo(todo);
        return new ResponseEntity<>(new ApiResponse(true, "berhasil di tambahkan"), HttpStatus.CREATED);
    }

    @PostMapping("/update/{todoId}")
    public ResponseEntity<ApiResponse> updateTodo(@PathVariable("todoId") Integer todoId, @Valid @RequestBody Todo todo){
        if (Objects.nonNull(service.readTodo(todoId))){
            service.updateTodo(todoId, todo);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "update berhasil"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "todo tidak  di temukan "), HttpStatus.NOT_FOUND);
    }
}
