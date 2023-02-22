<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>


<h2>Employee Info</h2>
<br>

<form:form action="saveEmployee" modelAttribute="employee">

<%--    скрытое поле--%>
    <form:hidden path="id"></form:hidden>


    Name <form:input path="name"></form:input>
    <br><br>
    Surname <form:input path="surname"></form:input>
    <br><br>
    Department <form:input path="department"></form:input>
    <br><br>
    Salary <form:input path="salary"></form:input>
    <br><br>
    <input type="submit" value="OK">
    <br><br>

</form:form>

</body>

</html>