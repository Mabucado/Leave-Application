<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Leave Application Form</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4>Leave Application Form</h4>
        </div>

        <div class="card-body">

            <form method="post" action="/apply/submit">

                <!-- Hidden User ID (normally from session) -->
                <input type="hidden" name="userId" value="1"/>

                <!-- Employee Name -->
                <div class="mb-3">
                    <label class="form-label">Employee Name</label>
                    <input type="text" name="employeeName" class="form-control" required>
                </div>

                <!-- Leave Type -->
                <div class="mb-3">
                    <label class="form-label">Leave Type</label>
                    <select name="leaveType" class="form-select" required>
                        <option value="">Select Type</option>
                        <option value="Annual Leave">Annual Leave</option>
                        <option value="Sick Leave">Sick Leave</option>
                        <option value="Study Leave">Study Leave</option>
                    </select>
                </div>

                <!-- Start Date -->
                <div class="mb-3">
                    <label class="form-label">Start Date</label>
                    <input type="date" name="startDate" class="form-control" required>
                </div>

                <!-- End Date -->
                <div class="mb-3">
                    <label class="form-label">End Date</label>
                    <input type="date" name="endDate" class="form-control" required>
                </div>

                <!-- Hidden Status -->
                <input type="hidden" name="status" value="PENDING"/>

                <div class="text-end">
                    <button type="submit" class="btn btn-primary">
                        Submit Application
                    </button>
                </div>

            </form>

        </div>
    </div>

</div>

</body>
</html>