package com.example.demo.controller;
import com.example.demo.model.LeaveApplication;
import com.example.demo.service.LeaveService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Map;

@Controller
public class Dashboard {
    @Autowired
    LeaveService leaveService;

    public void setLeaveService(LeaveService leaveService) {}
    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request) {
        Long userId = 1L; // normally fetched from session / security context
        request.setAttribute("userName", "Sibusiso");

        // Leave summary
        Map<String, Integer> leaveSummary = Map.of(
                "annualLeave", leaveService.getLeaveCountByType(userId, "Annual Leave"),
                "sickLeave", leaveService.getLeaveCountByType(userId, "Sick Leave"),
                "pendingRequests", leaveService.getLeaveCountByStatus(userId, "Pending"),
                "approvedDays", leaveService.getLeaveCountByStatus(userId, "Approved")
        );
        request.setAttribute("leaveSummary", leaveSummary);

        // Recent activity
        List<LeaveApplication> recentLeaves = leaveService.getRecentLeaves(userId);
        request.setAttribute("recentActivities", recentLeaves);

        return "dashboard"; // /WEB-INF/jsp/dashboard.jsp



    }
}
