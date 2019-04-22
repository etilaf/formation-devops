package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownOwnerException;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownEventException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public Event createEvent(Event event) {
        Assert.notNull(event, "Event cannot be null");
        final Event newEvent = new Event(
                event.getName(),
                event.getStartDate(),
                event.getEndDate(),
                event.getStatus(),
                event.getOwner(),
                event.getDescription()
        );
        return eventRepository.save(newEvent);
    }
    public Event getEvent(Long id) {
        Assert.notNull(id, "Event ID cannot be null");
        return eventRepository.findById(id)
                .orElseThrow(() -> new UnknownEventException(id));
    }

    public void updateEvent(Event event) {
        Assert.notNull(event, "Event cannot be null");
        this.getEvent(event.getId());
        eventRepository.save(event);
    }

    public List<Event> listEventByOwner(String owner, Date startDate, Date endDate) {
        Assert.notNull(owner, "Event OWNER cannot be null");
        Assert.notNull(startDate, "Event STARTDATE cannot be null");
        Assert.notNull(endDate, "Event ENDDATE cannot be null");

        return eventRepository.listEventByOwner(owner, startDate, endDate);
    }

    public Event getEvent(String owner) {
        Assert.notNull(owner, "Event owner cannot be null");
        return eventRepository.findByOwner(owner)
                .orElseThrow(() -> new UnknownOwnerException(owner));
    }

    public void deleteEvent(Long id) {
        Assert.notNull(id, "ID cannot be null");
        eventRepository.delete(id);
    }

    public List<Event> getEvent() {
        return eventRepository.findAll();

    }
/*
    public Event getEmployee(Long id) {
        Assert.notNull(id, "Event ID cannot be null");
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UnknownEmployeeException(id));
    }

    public Event getEvent(String owner) {
        Assert.notNull(owner, "Event owner cannot be null");
        return eventRepository.findByOwner(owner)
                .orElseThrow(() -> new UnknownOwnerException(owner));
    }

/*

    public Event createEmployee(Event event) {
        Assert.notNull(event, "Event cannot be null");
        final Event newEvent = new Event(
                event.getFirstName(),
                event.getLastName(),
                event.getEmail(),
                Collections.emptyList()
        );
        return employeeRepository.save(newEvent);
    }

    public void updateEmployee(Event event) {
        Assert.notNull(event, "Event cannot be null");
        this.getEmployee(event.getId());
        employeeRepository.save(event);
    }

    public List<Skill> getEmployeeSkills(Long employeeId) {
        return skillRepository.findByEmployeeId(employeeId);
    }

    public void deleteEmployee(Long id) {
        Assert.notNull(id, "ID cannot be null");
        employeeRepository.delete(id);
    }
    */
}
