package com.example.app.entity.task;
import java.lang.Long;


public record TaskEntity(
    Long id,
    String summary,
    String description,
    TaskStatus status
) {
    
}
