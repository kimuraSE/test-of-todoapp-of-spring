package com.example.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.app.model.task.Task;
import com.example.app.services.task.TaskService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




//branch


@Controller
@RequestMapping("/tasks")
//このlombokのアノテーションのおかげで、コンストラクタが必要なくなる。
public class TaskController {
    @Autowired
    TaskService service;
    //依存性の注入




    @GetMapping
    public String list(Model model) {
        var taskList = service.findALL();
        model.addAttribute("tasks", taskList);
        return "tasks/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Integer taskId, Model model){
        
        Optional<Task> entity = service.findById(taskId);
        entity.ifPresent(e ->
        model.addAttribute("task", e)
        );
        return "tasks/detail";
    }

    @GetMapping("/create")
    public String showCretationForm() {
        return "tasks/form";
    }

    @PostMapping
    public String create(@ModelAttribute Task task) {
        service.insert(task);
        return "redirect:/tasks";
    }
    
    
}