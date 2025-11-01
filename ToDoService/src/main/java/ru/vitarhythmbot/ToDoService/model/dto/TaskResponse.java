package ru.vitarhythmbot.ToDoService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vitarhythmbot.ToDoService.model.ToDoTask;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private DayOfWeek dayOfWeek;
    private LocalTime time;
    private boolean completed;
    private String tag;

    // Конвертация из Entity
    public static TaskResponse fromEntity(ToDoTask task) {
        return TaskResponse.builder()
                .id(task.getId())
                .userId(task.getUserId())
                .title(task.getTitle())
                .description(task.getDescription())
                .dayOfWeek(task.getDayOfWeek())
                .time(task.getTime())
                .completed(task.isCompleted())
                .tag(task.getTag())
                .build();
    }
}
