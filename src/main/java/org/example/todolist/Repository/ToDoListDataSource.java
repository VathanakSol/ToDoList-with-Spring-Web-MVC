package org.example.todolist.Repository;

import org.example.todolist.Model.ToDoList;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ToDoListDataSource extends JpaRepository<ToDoList, Long> {
    @Bean
    List<ToDoList> findAll();
    ToDoList findById(int id);
    <S extends ToDoList> S save(S todoItem);
    void deleteById(Long id);
}
