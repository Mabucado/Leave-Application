package com.example.demo.repository;


import com.example.demo.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<LeaveApplication, Long> {
    List<LeaveApplication> findTop5ByUserIdOrderByStartDateDesc(Long userId);
    List<LeaveApplication> findByUserIdOrderByStartDateDesc(Long userId);
    int countByuserIdAndLeaveType(Long userId, String type);
    int countByuserIdAndStatus(Long userId, String status);
}