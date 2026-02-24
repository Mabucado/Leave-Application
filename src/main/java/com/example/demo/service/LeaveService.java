package com.example.demo.service;

import com.example.demo.model.LeaveApplication;
import com.example.demo.repository.LeaveRepository;
import org.springframework.stereotype.Service;
import lombok.*;
import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public LeaveApplication applyLeave(LeaveApplication leave) {
        leave.setStatus("PENDING");
        return leaveRepository.save(leave);
    }

    public LeaveApplication approveLeave(Long id) {
        LeaveApplication leave = leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus("APPROVED");
        return leaveRepository.save(leave);
    }

    public LeaveApplication rejectLeave(Long id) {
        LeaveApplication leave = leaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setStatus("REJECTED");
        return leaveRepository.save(leave);
    }
    public List<LeaveApplication> getRecentLeaves(Long userId) {
        return leaveRepository.findTop5ByUserIdOrderByStartDateDesc(userId);
    }

    public int getLeaveCountByType(Long userId, String type) {
        return leaveRepository.countByuserIdAndLeaveType(userId, type);
    }

    public int getLeaveCountByStatus(Long userId, String status) {
        return leaveRepository.countByuserIdAndStatus(userId, status);
    }

    public List<LeaveApplication> getAllLeaves() {
        return leaveRepository.findAll();
    }
}
