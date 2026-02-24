<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Leave History</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4>Leave History</h4>
        </div>

        <div class="card-body">

            <table class="table table-bordered table-hover">
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
                        <td>${leave.type}</td>
                        <td>${leave.startDate}</td>
                        <td>${leave.endDate}</td>
                        <td>
                            <c:choose>
                                <c:when test="${leave.status == 'Approved'}">
                                    <span class="badge bg-success">Approved</span>
                                </c:when>
                                <c:when test="${leave.status == 'Pending'}">
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