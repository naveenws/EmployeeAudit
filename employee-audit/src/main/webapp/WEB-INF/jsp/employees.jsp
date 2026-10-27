<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
</head>
<body>

    <h2>Employee Management</h2>

    <c:if test="${not empty error}">
        <p style="color:red">
            <c:out value="${error}"/>
        </p>
    </c:if>

    <form action="${pageContext.request.contextPath}/employees"
          method="post">

        Employee Name:
        <input type="text" name="name" required>

        <br><br>

        Department:
        <input type="text" name="department" required>

        <br><br>

        <button type="submit">Add Employee</button>
    </form>

    <h3>Employee Details</h3>

    <table border="1" cellpadding="8">
        <tr>
            <th>Name</th>
            <th>Department</th>
        </tr>

        <c:forEach var="e" items="${employees}">
            <tr>
                <td><c:out value="${e.name}"/></td>
                <td><c:out value="${e.department}"/></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>