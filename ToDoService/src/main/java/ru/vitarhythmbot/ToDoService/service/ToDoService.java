package ru.vitarhythmbot.ToDoService.service;

import com.sun.source.util.TaskEvent;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vitarhythmbot.ToDoService.model.ToDoTask;
import ru.vitarhythmbot.ToDoService.model.dto.TaskRequest;
import ru.vitarhythmbot.ToDoService.model.dto.TaskResponse;
import ru.vitarhythmbot.ToDoService.repository.ToDoRepository;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public TaskResponse createTask(TaskRequest request) {
        ToDoTask task = ToDoTask.builder()
                .userId(request.getUserId())
                .title(request.getTitle())
                .description(request.getDescription())
                .dayOfWeek(request.getDayOfWeek())
                .time(request.getTime())
                .tag(request.getTag())
                .build();

        ToDoTask savedTask = toDoRepository.save(task);

        // Публикуем событие в Kafka
        eventPublisher.publishEvent(
                new TaskEvent(savedTask, TaskEventType.CREATED)
        );

        return TaskResponse.fromEntity(savedTask);
    }
}
