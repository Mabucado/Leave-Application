package com.example.demo.controller;

import com.example.demo.model.LeaveApplication;
import com.example.demo.model.LeaveBalance;
import com.example.demo.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class Dashboard {

    @Autowired
    LeaveService leaveService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        Long userId = 1L; // later fetch from session
        model.addAttribute("userName", "Sibusiso");

        // 🔹 Get Leave Balance from DB
        LeaveBalance balance = leaveService.getLeaveBalance(userId);
        if(balance == null){
            balance = new LeaveBalance();
            balance.setTotalAnnualLeave(0);
        }
        int totalAnnual = balance.getTotalAnnualLeave();
        int totalSick = balance.getTotalSickLeave();
        System.out.println("Total Annual: " + totalAnnual);
        System.out.println("total sick"+totalSick);

        // 🔹 Used leave from LeaveApplication table
        int usedAnnual = leaveService.getLeaveCountByType(userId, "Annual Leave");
        int usedSick = leaveService.getLeaveCountByType(userId, "Sick Leave");

        int pending = leaveService.getLeaveCountByStatus(userId, "PENDING");

        Map<String, Integer> leaveSummary = Map.of(
                "pendingRequests", pending,
                "annualRemaining", totalAnnual - usedAnnual,
                "sickRemaining", totalSick - usedSick
        );

        model.addAttribute("leaveSummary", leaveSummary);

        // 🔹 Recent activity
        List<LeaveApplication> recentLeaves = leaveService.getRecentLeaves(userId);
        model.addAttribute("recentActivities", recentLeaves);

        return "dashboard";
    }
}