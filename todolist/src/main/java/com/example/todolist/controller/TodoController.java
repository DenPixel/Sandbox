package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.entity.request.TodoRequest;
import com.example.todolist.servise.TodoCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo-lists")
public class TodoController {

    private final TodoCRUD todoCRUD;

    @Autowired
    public TodoController(TodoCRUD todoCRUD) {
        this.todoCRUD = todoCRUD;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Todo create(@RequestBody TodoRequest todo){
        return todoCRUD.create(todo);
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable UUID id){
        return todoCRUD.getById(id).orElseThrow();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Todo update(@PathVariable UUID id, @RequestBody TodoRequest request){
        return todoCRUD.update(id, request);
    }

    @DeleteMapping("/{id}")
    public Todo delete(@PathVariable UUID id){
        return todoCRUD.deleteById(id).orElseThrow();
    }

    @GetMapping("/all-not-done")
    public List<Todo> getAllNotDone(){
        return todoCRUD.getAllNotDone();
    }

    @GetMapping
    public List<Todo> getAllTodoList(){
        return todoCRUD.getAllTodoList();
    }
}
