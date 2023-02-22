<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>Employee, you are welcome!</h2>
<br>
<br>
<br>

<%--Your name: ${param.employeeName}--%>

Your name: ${employee.name}
<br>
Your surname: ${employee.sirname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>
Your car: ${employee.carBrand}
<br>
Language(s):
<%--    <ul> - unordered list для вывода списка --%>
<ul>
    <c:forEach var="str" items="${employee.languages}">
        <%--        <li> - list item это элемент списка--%>
        <li>${str}</li>
    </c:forEach>
</ul>
<br>
Your phoneNumber: ${employee.phoneNumber}
<br>
Your eMail: ${employee.email}
<br>


</body>


</html>