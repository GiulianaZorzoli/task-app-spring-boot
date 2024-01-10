package com.example.springboottodoapp.repositories;

import com.example.springboottodoapp.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {
}
