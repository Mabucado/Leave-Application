package com.example.demo.controller;

import com.example.demo.model.LeaveApplication;
import com.example.demo.service.LeaveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(Dashboard.class)
@AutoConfigureMockMvc(addFilters = false)
class DashboardTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LeaveService leaveService;

    @Test
    void shouldReturnDashboardViewWithCorrectData() throws Exception {

        // Arrange (Mock service behavior)
        when(leaveService.getLeaveCountByType(anyLong(), anyString()))
                .thenReturn(0);   // Annual & Sick mocked as 5

        when(leaveService.getLeaveCountByStatus(anyLong(), anyString()))
                .thenReturn(2);   // Pending & Approved mocked as 2

        when(leaveService.getRecentLeaves(anyLong()))
                .thenReturn(List.of(new LeaveApplication()));

        // Act & Assert
        mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard"))
                .andExpect(model().attributeExists("userName"))
                .andExpect(model().attributeExists("leaveSummary"))
                .andExpect(model().attributeExists("recentActivities"))
                .andExpect(result -> {
                    Map<String, Integer> summary =
                            (Map<String, Integer>) result
                                    .getModelAndView()
                                    .getModel()
                                    .get("leaveSummary");

                    assertEquals(0, summary.get("annualRemaining"));
                    assertEquals(0, summary.get("sickRemaining"));
                    assertEquals(2, summary.get("pendingRequests"));
                });
    }
}