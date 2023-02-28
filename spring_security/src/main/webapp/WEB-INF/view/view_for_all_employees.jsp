<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<body>


<h3>Information for all employees</h3>
<br><br>

<security:authorize access="hasRole('HR')">
    <input type="button" value="Salary"
           onclick="window.location.href = 'hrInfo'">
    only for HR stuff
    <br><br>
</security:authorize>


<security:authorize access="hasRole('MANAGER')">
    <input type="button" value="Perfomance"
           onclick="window.location.href = 'managerInfo'">
    only for Managers
    <br><br>
</security:authorize>



</body>


</html>