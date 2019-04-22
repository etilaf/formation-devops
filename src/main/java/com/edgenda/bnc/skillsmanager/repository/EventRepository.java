package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findById(Long id);

    @Query("SELECT event FROM Event event WHERE event.id = ?1")
    List<Event> findByEventId(Long eventId);

    @Query("SELECT e FROM Event e WHERE e.owner = ?1 AND (e.startDate >= ?2 AND e.startDate <= ?3) ORDER BY e.startDate")
    List<Event> listEventByOwner(String owner, LocalDateTime startPeriod, LocalDateTime endPeriod);

}
