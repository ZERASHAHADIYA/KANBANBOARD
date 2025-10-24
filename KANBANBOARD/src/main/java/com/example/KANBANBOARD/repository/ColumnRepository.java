package com.example.KANBANBOARD.repository;

import com.example.KANBANBOARD.model.KanbanColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ColumnRepository extends JpaRepository<KanbanColumn, Long> {
    List<KanbanColumn> findAllByOrderByPositionAsc();
}