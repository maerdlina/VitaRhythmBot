package ru.vitarhythmbot.ToDoService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @GetMapping("/getToDo")
    public String getToDo() {
        return "To-do list loaded!";
    }

}
