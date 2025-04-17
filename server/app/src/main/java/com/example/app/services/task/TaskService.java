package com.example.app.services.task;
import com.example.app.model.task.Task;
import com.example.app.repository.TaskRepository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findALL(){

        var taskList = taskRepository.findAll(); // List<TaskModel> を取得
        return taskList;// List<TaskEntity> に変換して返す
    }
    //Optionalとは、データが存在しなかったらnullを返す制約をつける
    public Optional<Task> findById(Integer taskId){
        var task = taskRepository.findById(taskId);
        return task;
    }
    @Transactional
    public void insert(Task task){
        taskRepository.save(task);
    }
    
}