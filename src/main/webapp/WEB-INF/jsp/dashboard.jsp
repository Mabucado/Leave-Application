<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Leave Management System</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="d-flex">

    <!-- ================= SIDEBAR ================= -->
    <div class="bg-primary text-white p-4" style="width:260px; min-height:100vh;">

        <h5 class="fw-bold mb-4">LMS – Leave Management</h5>

        <small class="text-uppercase opacity-75">Main</small>
        <ul class="nav flex-column mb-4 mt-2">
            <li class="nav-item mb-2">
                <a href="/dashboard" class="nav-link text-white bg-white bg-opacity-10 rounded">
                    <i class="bi bi-grid me-2"></i> Dashboard
                </a>
            </li>
            <li class="nav-item mb-2">
                <a href="/apply" class="nav-link text-white">
                    <i class="bi bi-plus-circle me-2"></i> Apply for Leave
                </a>
            </li>
            <li class="nav-item">
                <a href="/leave-history" class="nav-link text-white">
                    <i class="bi bi-clock me-2"></i> Leave History
                </a>
            </li>
        </ul>

        <small class="text-uppercase opacity-75">Management</small>
        <ul class="nav flex-column mt-2">
            <li class="nav-item mb-2">
                <a href="#" class="nav-link text-white">
                    <i class="bi bi-bar-chart me-2"></i> Reports
                </a>
            </li>
        </ul>

    </div>
    <!-- ================= END SIDEBAR ================= -->


    <!-- ================= MAIN CONTENT ================= -->
    <div class="flex-grow-1 p-4">

        <div class="container-fluid">

            <!-- Breadcrumb -->
            <nav class="mb-3">
                <small class="text-muted">Dashboard > Overview</small>
            </nav>

            <!-- Gradient Header -->
            <div class="card border-0 shadow-sm mb-4 text-white"
                 style="background: linear-gradient(90deg,#3563E9,#243B8F); border-radius: 18px;">
                <div class="card-body d-flex justify-content-between align-items-center p-4">
                    <div>
                        <h3 class="fw-bold mb-1">Employee Dashboard</h3>
                        <p class="mb-0 opacity-75">
                            Manage your leave requests and balances
                        </p>
                    </div>
                    <a href="/apply" class="btn btn-light rounded-pill px-4">
                        <i class="bi bi-plus"></i> Apply for Leave
                    </a>
                </div>
            </div>

            <!-- Stats Row -->
            <div class="row g-4 mb-4">

                <div class="col-md-3">
                    <div class="card border-0 shadow-sm rounded-4">
                        <div class="card-body">
                            <div class="d-flex justify-content-between mb-3">
                                <span class="text-muted">Annual Leave Remaining</span>
                                <div class="bg-primary bg-opacity-10 text-primary p-2 rounded">
                                    <i class="bi bi-calendar"></i>
                                </div>
                            </div>
                            <h2 class="fw-bold"> ${leaveSummary.annualRemaining}</h2>
                            <small class="text-muted">Days</small>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card border-0 shadow-sm rounded-4">
                        <div class="card-body">
                            <div class="d-flex justify-content-between mb-3">
                                <span class="text-muted">Sick Leave Remaining</span>
                                <div class="bg-success bg-opacity-10 text-success p-2 rounded">
                                    <i class="bi bi-bag"></i>
                                </div>
                            </div>
                            <h2 class="fw-bold">${leaveSummary.sickRemaining}</h2>
                            <small class="text-muted">Days</small>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card border-0 shadow-sm rounded-4">
                        <div class="card-body">
                            <div class="d-flex justify-content-between mb-3">
                                <span class="text-muted">Pending Requests</span>
                                <div class="bg-warning bg-opacity-10 text-warning p-2 rounded">
                                    <i class="bi bi-file-earmark-text"></i>
                                </div>
                            </div>
                            <h2 class="fw-bold">${leaveSummary.pendingRequests}</h2>
                            <small class="text-muted">Request</small>
                        </div>
                    </div>
                </div>



            </div>

        </div>

    </div>
    <!-- ================= END MAIN CONTENT ================= -->

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>