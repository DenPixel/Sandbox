package com.example.todolist.servise;

import com.example.todolist.entity.Todo;
import com.example.todolist.entity.request.TodoRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoCRUD {
    Todo create(TodoRequest request);

    Optional<Todo> getById(UUID id);

    Todo update(UUID id, TodoRequest request) ;

    Optional<Todo> deleteById(UUID id);

    List<Todo> getAllNotDone();

    List<Todo> getAllTodoList();
}
