
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LeaveHistoryController {

    @GetMapping("/leave-history")
    public String viewLeaveHistory(Model model) {

        // Dummy data (Replace with database later)
        List<LeaveRecord> leaveList = new ArrayList<>();

        leaveList.add(new LeaveRecord("Annual Leave", "2026-02-10", "2026-02-15", "Approved"));
        leaveList.add(new LeaveRecord("Sick Leave", "2026-01-05", "2026-01-06", "Pending"));
        leaveList.add(new LeaveRecord("Study Leave", "2025-12-01", "2025-12-03", "Rejected"));

        model.addAttribute("leaveList", leaveList);

        return "leave-history"; // leave-history.jsp
    }

    // Simple inner class (replace with Entity later)
    public static class LeaveRecord {
        private String type;
        private String startDate;
        private String endDate;
        private String status;

        public LeaveRecord(String type, String startDate, String endDate, String status) {
            this.type = type;
            this.startDate = startDate;
            this.endDate = endDate;
            this.status = status;
        }

        public String getType() { return type; }
        public String getStartDate() { return startDate; }
        public String getEndDate() { return endDate; }
        public String getStatus() { return status; }
    }
}