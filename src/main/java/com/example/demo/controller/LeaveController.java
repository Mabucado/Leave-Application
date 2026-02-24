package com.example.demo.controller;

import com.example.demo.model.LeaveApplication;
import com.example.demo.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveController {


    private final LeaveService leaveService;

    // Feature 1 – Apply Leave
    @PostMapping("/apply")
    public LeaveApplication applyLeave(@RequestBody LeaveApplication leave) {
        return leaveService.applyLeave(leave);
    }

    // Feature 2 – Approve Leave
    @PutMapping("/{id}/approve")
    public LeaveApplication approveLeave(@PathVariable Long id) {
        return leaveService.approveLeave(id);
    }

    // Reject Leave
    @PutMapping("/{id}/reject")
    public LeaveApplication rejectLeave(@PathVariable Long id) {
        return leaveService.rejectLeave(id);
    }

    @GetMapping
    public List<LeaveApplication> getAllLeaves() {
        return leaveService.getAllLeaves();
    }
}
