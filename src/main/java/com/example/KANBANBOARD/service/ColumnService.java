package com.example.KANBANBOARD.service;

import com.example.KANBANBOARD.model.KanbanColumn;
import com.example.KANBANBOARD.repository.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ColumnService {
    @Autowired
    private ColumnRepository columnRepository;

    public List<KanbanColumn> getAllColumns() {
        return columnRepository.findAllByOrderByPositionAsc();
    }

    public Optional<KanbanColumn> getColumnById(Long id) {
        return columnRepository.findById(id);
    }

    public KanbanColumn createColumn(KanbanColumn column) {
        return columnRepository.save(column);
    }

    public KanbanColumn updateColumn(Long id, KanbanColumn columnDetails) {
        KanbanColumn column = columnRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Column not found"));

        column.setName(columnDetails.getName());
        column.setPosition(columnDetails.getPosition());

        return columnRepository.save(column);
    }

    public void deleteColumn(Long id) {
        columnRepository.deleteById(id);
    }
}