<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Leave History</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- Bootstrap Icons (IMPORTANT — you forgot this) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
          rel="stylesheet">

    <style>
        body {
            display: flex;
        }

        .sidebar {
            width: 260px;
            min-height: 100vh;
        }

        .content-area {
            flex: 1;
            padding: 40px;
        }
    </style>

</head>

<body class="bg-light">

<!-- ================= SIDEBAR ================= -->
<div class="sidebar bg-primary text-white p-4">

    <h5 class="fw-bold mb-4">LMS – Leave Management</h5>

    <small class="text-uppercase opacity-75">Main</small>

    <ul class="nav flex-column mb-4 mt-2">

        <li class="nav-item mb-2">
            <a href="/dashboard" class="nav-link text-white">
                <i class="bi bi-grid me-2"></i> Dashboard
            </a>
        </li>

        <li class="nav-item mb-2">
            <a href="/apply" class="nav-link text-white">
                <i class="bi bi-plus-circle me-2"></i> Apply for Leave
            </a>
        </li>

        <li class="nav-item">
            <a href="/leave-history" class="nav-link text-white bg-white bg-opacity-10 rounded">
                <i class="bi bi-clock me-2"></i> Leave History
            </a>
        </li>

    </ul>

</div>
<!-- ================= END SIDEBAR ================= -->


<!-- ================= CONTENT ================= -->
<div class="content-area">

    <div class="card shadow border-0 rounded-4">

        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Leave History</h4>
        </div>

        <div class="card-body">

            <table class="table table-hover table-bordered align-middle">

                <thead class="table-dark">
                <tr>
                    <th>Leave Type</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Status</th>
                </tr>
                </thead>

                <tbody>

                <c:forEach var="leave" items="${leaveList}">

                    <tr>
                        <td>${leave.leaveType}</td>
                        <td>${leave.startDate}</td>
                        <td>${leave.endDate}</td>

                        <td>
                            <c:choose>

                                <c:when test="${leave.status == 'APPROVED'}">
                                    <span class="badge bg-success">Approved</span>
                                </c:when>

                                <c:when test="${leave.status == 'PENDING'}">
                                    <span class="badge bg-warning text-dark">Pending</span>
                                </c:when>

                                <c:otherwise>
                                    <span class="badge bg-danger">Rejected</span>
                                </c:otherwise>

                            </c:choose>
                        </td>

                    </tr>

                </c:forEach>

                </tbody>

            </table>

        </div>
    </div>

</div>

</body>
</html>