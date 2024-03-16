package org.example.todolist.Service;

import org.example.todolist.Model.ToDoList;
import org.example.todolist.Repository.ToDoListDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoListDataSource toDoListDataSource;
    public List<ToDoList> getAllToDoItems() {
        return toDoListDataSource.findAll();
    }
    public ToDoList getToDoItemById(Long id) {
        return toDoListDataSource.findById(id).orElse(null); // Handle case where item is not found
    }
    public ToDoList addToDoItem(ToDoList toDoItem) {
        return toDoListDataSource.save(toDoItem);
    }
    public ToDoList updateToDoItem(Long id, ToDoList toDoItem) {
        ToDoList existingItem = toDoListDataSource.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.setTask(toDoItem.getTask());
            return toDoListDataSource.save(existingItem);
        } else {
            return null;
        }
    }
    public void deleteToDoItem(Long id) {
        toDoListDataSource.deleteById(id);
    }
}
