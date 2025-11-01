package ru.vitarhythmbot.ToDoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vitarhythmbot.ToDoService.model.ToDoTask;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoTask, Long> {
    List<ToDoTask> findByUserIdAndDayOfWeek(Long userId, DayOfWeek dayOfWeek);

    @Query("SELECT t FROM ToDoTask t " +
            "WHERE t.userId = :userId AND t.dayOfWeek = :dayOfWeek " +
            "AND t.completed = false")
    List<ToDoTask> findTodayActiveTasks(
            @Param("userId") Long userId,
            @Param("dayOfWeek") DayOfWeek dayOfWeek
    );

    boolean existsByUserIdAndDayOfWeek(Long userId, DayOfWeek dayOfWeek);
}
