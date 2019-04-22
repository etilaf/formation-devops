package com.edgenda.bnc.skillsmanager.rest;

import com.edgenda.bnc.skillsmanager.model.Event;
import com.edgenda.bnc.skillsmanager.service.EventService;
import com.edgenda.bnc.skillsmanager.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.edgenda.bnc.skillsmanager.model.Event;
import org.springframework.format.annotation.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }
/*
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }
*/
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> listEventByOwner(
                                            @RequestParam("owner") String owner,
                                            @RequestParam(name = "startPeriod",required = false, defaultValue = "1900-01-01T00:00:00") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date startPeriod,
                                            @RequestParam(name = "endPeriod",required = false, defaultValue = "9999-12-31T23:59:59") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date endPeriod) {
        return eventService.listEventByOwner(owner, startPeriod, endPeriod);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "L'evenement a été supprimé";
    }


/*
    @RequestMapping(method = RequestMethod.GET)
    public Event getEvent(@RequestParam("owner") String owner) {
        return eventService.getEvent(owner);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Event getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Event getEvent(@RequestParam("owner") String owner) {
        return eventService.getEvent(owner);
    }
/*


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
