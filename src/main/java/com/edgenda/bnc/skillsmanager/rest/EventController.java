package com.edgenda.bnc.skillsmanager.rest;

import com.edgenda.bnc.skillsmanager.service.EventService;
import com.edgenda.bnc.skillsmanager.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
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
