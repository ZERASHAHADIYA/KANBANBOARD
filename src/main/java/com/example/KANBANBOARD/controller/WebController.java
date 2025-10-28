package com.example.KANBANBOARD.controller;

import com.example.KANBANBOARD.model.Task;
import com.example.KANBANBOARD.model.KanbanColumn;
import com.example.KANBANBOARD.service.TaskService;
import com.example.KANBANBOARD.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ColumnService columnService;

    @GetMapping("/")
    public String index(Model model) {
        List<KanbanColumn> columns = columnService.getAllColumns();
        List<Task> allTasks = taskService.getAllTasks();

        // Initialize default columns if none exist
        if (columns.isEmpty()) {
            initializeDefaultColumns();
            columns = columnService.getAllColumns();
        }

        // Calculate statistics
        long totalTasks = allTasks.size();
        long inProgressTasks = allTasks.stream()
                .filter(t -> "In Progress".equals(t.getStatus()))
                .count();
        long completedTasks = allTasks.stream()
                .filter(t -> "Done".equals(t.getStatus()))
                .count();

        model.addAttribute("columns", columns);
        model.addAttribute("totalTasks", totalTasks);
        model.addAttribute("inProgressTasks", inProgressTasks);
        model.addAttribute("completedTasks", completedTasks);

        return "index";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute Task task, @RequestParam Long columnId) {
        KanbanColumn column = columnService.getColumnById(columnId)
                .orElseThrow(() -> new RuntimeException("Column not found"));

        task.setColumn(column);
        task.setStatus(column.getName());

        if (task.getTaskId() != null) {
            taskService.updateTask(task.getTaskId(), task);
        } else {
            taskService.createTask(task);
        }

        return "redirect:/";
    }

    private void initializeDefaultColumns() {
        KanbanColumn toDo = new KanbanColumn();
        toDo.setName("To Do");
        toDo.setPosition(0);
        columnService.createColumn(toDo);

        KanbanColumn inProgress = new KanbanColumn();
        inProgress.setName("In Progress");
        inProgress.setPosition(1);
        columnService.createColumn(inProgress);

        KanbanColumn done = new KanbanColumn();
        done.setName("Done");
        done.setPosition(2);
        columnService.createColumn(done);
    }
}