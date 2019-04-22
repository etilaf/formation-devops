package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findById(Long id);

    @Query("SELECT event FROM Event event WHERE event.id = ?1")
    List<Event> findByEventId(Long eventId);


    Optional<Event> findByOwner(String owner);

    @Query("SELECT event FROM Event event WHERE event.owner = ?1")
    List<Event> findByEventOwner(String eventOwner);

}

