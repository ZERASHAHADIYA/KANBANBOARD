package com.example.KANBANBOARD.controller;


import com.example.KANBANBOARD.model.KanbanColumn;
import com.example.KANBANBOARD.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/columns")
@CrossOrigin(origins = "*")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    @GetMapping
    public List<KanbanColumn> getAllColumns() {
        return columnService.getAllColumns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KanbanColumn> getColumnById(@PathVariable Long id) {
        return columnService.getColumnById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public KanbanColumn createColumn(@RequestBody KanbanColumn column) {
        return columnService.createColumn(column);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KanbanColumn> updateColumn(@PathVariable Long id, @RequestBody KanbanColumn column) {
        return ResponseEntity.ok(columnService.updateColumn(id, column));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColumn(@PathVariable Long id) {
        columnService.deleteColumn(id);
        return ResponseEntity.noContent().build();
    }
}
