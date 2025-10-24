package com.example.KANBANBOARD.service;

import com.example.KANBANBOARD.model.Task;
import com.example.KANBANBOARD.model.KanbanColumn;
import com.example.KANBANBOARD.repository.TaskRepository;
import com.example.KANBANBOARD.repository.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ColumnRepository columnRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByColumn(Long columnId) {
        return taskRepository.findByColumnColumnId(columnId);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setPriority(taskDetails.getPriority());

        if (taskDetails.getColumn() != null) {
            KanbanColumn column = columnRepository.findById(taskDetails.getColumn().getColumnId())
                    .orElseThrow(() -> new RuntimeException("Column not found"));
            task.setColumn(column);
        }

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task moveTask(Long taskId, Long columnId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        KanbanColumn column = columnRepository.findById(columnId)
                .orElseThrow(() -> new RuntimeException("Column not found"));

        task.setColumn(column);
        task.setStatus(column.getName());

        return taskRepository.save(task);
    }
}
