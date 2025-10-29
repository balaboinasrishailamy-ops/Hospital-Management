package com.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hms.model.*;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsernameAndPassword(String username, String password);
}

public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmailAndPassword(String email, String password);
}
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {}
