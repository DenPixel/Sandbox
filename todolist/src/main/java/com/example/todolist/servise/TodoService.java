package com.example.todolist.servise;

import com.example.todolist.entity.Todo;
import com.example.todolist.entity.request.TodoRequest;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TodoService implements TodoCRUD {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo create(TodoRequest request) {
        Todo todo = new Todo();
        todo.setText(request.getText());
        todo.setDone(request.isDone());
        return repository.save(todo);
    }

    @Override
    public Optional<Todo> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Todo update(UUID id, TodoRequest request) {
        Todo todo = repository.findById(id).orElseThrow();
        todo.setText(request.getText());
        todo.setDone(request.isDone());
        return repository.save(todo);
    }

    @Override
    public Optional<Todo> deleteById(UUID id) {
        Optional<Todo> todo = repository.findById(id);
        todo.ifPresent(repository::delete);
        return todo;
    }

    @Override
    public List<Todo> getAllNotDone() {
        return repository.findAllByDoneFalse();
    }
}
