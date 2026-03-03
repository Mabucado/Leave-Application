package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int totalAnnualLeave;
    private int totalSickLeave;

    // Relationship (Optional but recommended)
    @OneToMany(mappedBy = "userId")
    private java.util.List<LeaveApplication> leaveApplications;
}