package org.example.todolist.Controller;

import org.example.todolist.Model.ToDoList;
import org.example.todolist.Repository.ToDoListDataSource;
import org.example.todolist.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoListController {
    ApplicationContext context;
    @Autowired

    private ToDoListDataSource toDoListDataSource;
    @GetMapping("/todo/{id}" )
    public String showToDoList(Model show){
        show.addAttribute("todos",toDoListDataSource.findAll());
        return "index";
    }
    @GetMapping("/todo/new")
    public String addToDoList(Model add){
        add.addAttribute("todos",new ToDoService());
        return "add";
    }
    public String editToDoList(Model edit){
        edit.addAttribute("todos",new ToDoService());
        return "add";
    }
    public String deleteToDoList(Model delete){
        delete.addAttribute("todos",new ToDoService());
        return "add";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        // Add your logic to delete the task by ID
        return "redirect:/todos"; // Change if you have a different listing page
    }
    public String searchToDoList(Model search){
        search.addAttribute("todos",new ToDoService());
        return "add";
    }
}
