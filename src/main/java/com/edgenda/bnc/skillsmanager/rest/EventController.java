package com.edgenda.bnc.skillsmanager.rest;

import com.edgenda.bnc.skillsmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.edgenda.bnc.skillsmanager.model.Event;

@RestController
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String updateEvent(@PathVariable Long id, @RequestBody Event event) {
        eventService.updateEvent(
                new Event(
                        id,
                        event.getName(),
                        event.getStartDate(),
                        event.getEndDate(),
                        event.getStatus(),
                        event.getOwner(),
                        event.getDescription()
                )
        );
        return "Updated";
    }
/*
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEmployee(@RequestBody Event event) {
        return employeeService.createEmployee(event);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable Long id, @RequestBody Event event) {
        employeeService.updateEmployee(
                new Event(
                        id,
                        event.getFirstName(),
                        event.getLastName(),
                        event.getEmail(),
                        event.getSkills()
                )
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(path = "/{id}/skills", method = RequestMethod.GET)
    public List<Skill> getEmployeeSkills(@PathVariable Long id) {
        return employeeService.getEmployeeSkills(id);
    }
*/
}
