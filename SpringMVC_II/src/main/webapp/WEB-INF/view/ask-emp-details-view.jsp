<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>

<h2>Employee, enter your details</h2>

<br>
<br>

<%--    get - передает данные при отправке; post - не передает данные--%>
<form:form action = "showDetails" modelAttribute="employee" method="get">
    Name <form:input path="name"></form:input>
    <form:errors path="name"></form:errors>
    <br><br>
    Surname <form:input path="sirname"></form:input>
    <form:errors path="sirname"></form:errors>
    <br><br>
    Salary <form:input path="salary"></form:input>
    <form:errors path="salary"></form:errors>
    <br><br>
    Department <form:select path="department">
<%--    hardcoded, example from Map<String, String> departments (Employee.class) below--%>
<%--    <form:option value="Information Technology" label="IT"></form:option>--%>
<%--    <form:option value="Human Resources" label="HR"></form:option>--%>
<%--    <form:option value="Sales" label="Sales"></form:option>--%>
    <form:options items="${employee.departments}"></form:options>
    </form:select>
    <br><br>
    Which car do you want
<%--    hardcoded, example from Map<String, String> carBrands (Employee.class) below--%>
<%--    BMW <form:radiobutton path="carBrand" value="BMW"></form:radiobutton>--%>
<%--    Audi <form:radiobutton path="carBrand" value="Audi"></form:radiobutton>--%>
<%--    MB <form:radiobutton path="carBrand" value="Mercedes-Benz"></form:radiobutton>--%>
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"></form:radiobuttons>
    <br><br>
    Foreign language(s)
<%--    hardcoded--%>
<%--    EN <form:checkbox path="languages" value="English"></form:checkbox>--%>
<%--    GE <form:checkbox path="languages" value="German"></form:checkbox>--%>
<%--    FR <form:checkbox path="languages" value="French"></form:checkbox>--%>
    <form:checkboxes path="languages" items="${employee.languageList}"></form:checkboxes>
    <br><br>
    PhoneNumber <form:input path="phoneNumber"></form:input>
    <form:errors path="phoneNumber"></form:errors>
    <br><br>
    eMail <form:input path="email"></form:input>
    <form:errors path="email"></form:errors>
    <br><br>


    <input type="submit" value="ok">

</form:form>


</body>


</html>