package com.example.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.repository.UserRepository;

@RestController
public class UserController {

  private final UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @RequestMapping("/test")
  public String user() {
    return String.valueOf(repository.findAll());
  }
}
