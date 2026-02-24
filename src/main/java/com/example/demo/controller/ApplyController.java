package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apply")
public class ApplyController {

    // 🔹 Show Application Form
    @GetMapping
    public String showApplicationForm() {
        return "apply";  // application.jsp
    }

    // 🔹 Handle Form Submission
    @PostMapping("/submit")
    public String submitApplication(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String applicationType,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String reason,
            Model model
    ) {

        // For now just print to console (replace with DB save later)
        System.out.println("Application Submitted:");
        System.out.println(fullName);
        System.out.println(email);
        System.out.println(applicationType);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(reason);

        model.addAttribute("message", "Application submitted successfully!");

        return "dashboard";  // redirect to dashboard.jsp
    }
}