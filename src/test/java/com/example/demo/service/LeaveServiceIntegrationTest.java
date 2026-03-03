package com.example.demo.service;

import com.example.demo.model.LeaveApplication;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LeaveServiceIntegrationTest {

    @Autowired
    private LeaveService leaveService;

    @Test
    void shouldSaveLeaveApplicationSuccessfully() {

        LeaveApplication application = LeaveApplication.builder()
                .userId(1L)
                .employeeName("Test User")
                .leaveType("Annual Leave")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(2))
                .status("PENDING")
                .build();

        LeaveApplication saved = leaveService.saveApplication(application);

        assertNotNull(saved.getId());
        assertEquals("Test User", saved.getEmployeeName());
    }
}