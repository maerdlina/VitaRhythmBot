package ru.vitarhythmbot.ToDoService.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name="todo_tasks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dayOfWeek; // День недели (MONDAY, TUESDAY...)

    @Column(nullable = false)
    private LocalTime time; // Время напоминания

    @Column(nullable = false)
    @Builder.Default
    private boolean completed = false;

    @Column(length = 50)
    private String tag; // Тема / тег : работа, учеба, спорт и т.д.
}
