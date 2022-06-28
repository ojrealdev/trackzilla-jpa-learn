package com.keysoft.bucktrackerjpa.controller;

import com.keysoft.bucktrackerjpa.entity.Application;
import com.keysoft.bucktrackerjpa.entity.Release;
import com.keysoft.bucktrackerjpa.entity.Ticket;
import com.keysoft.bucktrackerjpa.service.IApplicationService;
import com.keysoft.bucktrackerjpa.service.IReleaseService;
import com.keysoft.bucktrackerjpa.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/tza")
public class TrackzillaController {

    @Autowired
    private IApplicationService applicationService;

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private IReleaseService releaseService;

    @PostMapping("/application")
    public ResponseEntity<Void> addApplication(@RequestBody Application application, UriComponentsBuilder builder) {
        boolean flag = applicationService.addApplication(application);
        if (!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/application/{id}").buildAndExpand(application.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Integer id) {
        Application app = applicationService.getApplicationById(id);
        return new ResponseEntity<Application>(app, HttpStatus.OK);

    }

    @PutMapping("/application")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
        applicationService.updateApplication(application);
        return new ResponseEntity<Application>(application, HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable("id") Integer id) {
        applicationService.deleteApplication(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Integer id) {
        Ticket ticket = ticketService.getTicketById(id);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> list = ticketService.getAllTickets();
        return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Void> addTicket(@RequestBody Ticket ticket, UriComponentsBuilder builder) {
        ticketService.addTicket(ticket);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/ticket/{id}").buildAndExpand(ticket.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/ticket")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        ticketService.updateTicket(ticket);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

    @DeleteMapping("/ticket/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("id") Integer id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/ticket/{id}")
    public ResponseEntity<Ticket> closeTicket(@PathVariable("id") Integer id) {
        ticketService.closeTicket(id);
        return new ResponseEntity<Ticket>(HttpStatus.OK);
    }

    @PostMapping("/release")
    public ResponseEntity<Void> addRelease(@RequestBody Release release, UriComponentsBuilder builder) {
        releaseService.addRelease(release);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/release").buildAndExpand(release.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/release/{appid}/{releaseid}")
    public ResponseEntity<Void> addApptoRelease(@PathVariable("appid") Integer appid, @PathVariable("releaseid") Integer releaseid, UriComponentsBuilder builder) {
        releaseService.addApplication(appid, releaseid);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

