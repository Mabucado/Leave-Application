package com.example.demo.controller;

import com.example.demo.model.LeaveApplication;
import com.example.demo.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LeaveHistoryController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/leave-history")
    public String viewLeaveHistory(Model model) {

        Long userId = 1L; // later get from session / security

        List<LeaveApplication> leaveList =
                leaveService.getLeavesByUser(userId);

        model.addAttribute("leaveList", leaveList);

        return "leave-history";
    }
}