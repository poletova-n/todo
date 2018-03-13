package com.todoapp.todo;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;
    public Task save(Task task){
        return repo.save(task);
    }
    public void delete(Task task){
        repo.delete(task.getId());
    }

    public List<Task> getAll(){
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(repo.findAll().iterator(),
                Spliterator.NONNULL),false).collect(Collectors.toList());
    }
}
