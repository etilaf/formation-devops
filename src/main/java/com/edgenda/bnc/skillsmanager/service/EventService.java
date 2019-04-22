package com.edgenda.bnc.skillsmanager.service;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.repository.EventRepository;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
/*
    public Event getEmployee(Long id) {
        Assert.notNull(id, "Event ID cannot be null");
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UnknownEmployeeException(id));
    }

    public List<Event> getEmployees() {
        return employeeRepository.findAll();
    }

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
