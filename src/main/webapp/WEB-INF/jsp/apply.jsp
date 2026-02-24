<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Application Form</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4>Application Form</h4>
        </div>

        <div class="card-body">

            <form method="post" action="/application/submit">

                <!-- Applicant Name -->
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" name="fullName" class="form-control" required>
                </div>

                <!-- Email -->
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" required>
                </div>

                <!-- Application Type -->
                <div class="mb-3">
                    <label class="form-label">Application Type</label>
                    <select name="applicationType" class="form-select" required>
                        <option value="">Select Type</option>
                        <option value="Leave">Leave</option>
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

                <!-- Reason -->
                <div class="mb-3">
                    <label class="form-label">Reason</label>
                    <textarea name="reason" class="form-control" rows="4" required></textarea>
                </div>

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