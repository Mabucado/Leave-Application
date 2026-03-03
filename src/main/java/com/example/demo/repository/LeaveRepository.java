package com.example.demo.repository;


import com.example.demo.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LeaveRepository extends JpaRepository<LeaveApplication, Long> {
    List<LeaveApplication> findTop5ByUserIdOrderByStartDateDesc(Long userId);
    List<LeaveApplication> findByUserIdOrderByStartDateDesc(Long userId);
    int countByuserIdAndLeaveType(Long userId, String type);
    int countByuserIdAndStatus(Long userId, String status);
}