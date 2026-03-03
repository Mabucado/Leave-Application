package com.example.demo.controller;

import com.example.demo.model.LeaveApplication;
import com.example.demo.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private LeaveService leaveService;
    LeaveApplication application = new LeaveApplication();

    // 🔹 Show Application Form
    @GetMapping
    public String showApplicationForm(Model model) {
        model.addAttribute("leaveApplication", new LeaveApplication());
        return "apply";
    }

    // 🔹 Handle Form Submission
    @PostMapping("/submit")
    public String submitApplication(
            @RequestParam Long userId,
            @RequestParam String employeeName,
            @RequestParam String leaveType,
            @RequestParam String startDate,
            @RequestParam String endDate,
            Model model
    ) {




        application.setUserId(userId);
        application.setEmployeeName(employeeName);
        application.setLeaveType(leaveType);
        application.setStartDate(LocalDate.parse(startDate));
        application.setEndDate(LocalDate.parse(endDate));
        application.setStatus("PENDING"); // default status

        leaveService.saveApplication(application);

        model.addAttribute("message", "Application submitted successfully!");

        return "dashboard";
    }
}