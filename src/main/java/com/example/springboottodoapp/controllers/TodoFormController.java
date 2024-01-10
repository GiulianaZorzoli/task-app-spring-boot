package com.example.springboottodoapp.controllers;

import com.example.springboottodoapp.model.TodoItem;
import com.example.springboottodoapp.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item= new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setType(todoItem.getType());
        item.setIsComplete(todoItem.getIsComplete());
        todoItemService.save(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem (@PathVariable("id") Long id, Model model){
        TodoItem todoItem =todoItemService.getById(id).orElseThrow(()->new IllegalArgumentException("TodoItem"+ id +"not found"));
        todoItemService.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editTodoItem(@PathVariable("id") Long id, Model model){
        TodoItem todoItem = todoItemService.getById(id).orElseThrow(()-> new IllegalArgumentException("TodoItem" + id +"not found"));
        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }
    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem,BindingResult result, Model model){
        TodoItem item = todoItemService.getById(id).orElseThrow(()-> new IllegalArgumentException("TodoItem" + id +"not found"));
        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());

        todoItemService.save(item);
        return "redirect:/";

    }
}
