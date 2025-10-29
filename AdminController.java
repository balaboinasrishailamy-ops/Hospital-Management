package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hms.model.*;
import com.hms.repository.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @PostMapping("/login")
    public String adminLogin(@RequestBody Admin admin) {
        Admin existing = adminRepo.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
        return (existing != null) ? "success" : "failed";
    }

    @PostMapping("/addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentRepo.findAll();
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }
}
