package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hms.model.*;
import com.hms.repository.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @PostMapping("/login")
    public String patientLogin(@RequestBody Patient patient) {
        Patient existing = patientRepo.findByEmailAndPassword(patient.getEmail(), patient.getPassword());
        return (existing != null) ? "success" : "failed";
    }

    @PostMapping("/bookAppointment")
    public Appointment bookAppointment(@RequestBody Appointment app) {
        app.setStatus("Pending");
        return appointmentRepo.save(app);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentRepo.findAll();
    }
}
