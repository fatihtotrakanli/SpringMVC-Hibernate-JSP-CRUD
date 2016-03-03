<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TaskList Question 9-10</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    
<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/bootstrap.min.js" />"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
    <ul class="nav navbar-nav">
      <li class="active"><a href="index">Home</a></li>
    </ul>
  </div>
</nav>
<div class="container">

<h3>Add New Employee and Meeting</h3>
<form action='add' method='post'>
 
    <table class='table table-hover table-responsive table-bordered'>
 
        <tr>
            <td><b>Name</b></td>
            <td><input type='text' name='emp_name' class='form-control' /></td>
        </tr>
 
        <tr>
            <td><b>Surname</b></td>
            <td><input type='text' name='emp_surname' class='form-control' /></td>
        </tr>
 
        <tr>
            <td><b>Salary</b></td>
            <td><input type='text' name='emp_salary' class='form-control' size="20" /></td>
            
        </tr>
 
        <tr>
            <td><b>Department</b></td>
            <td>
           <select name="dep_name">
           		  <option value="Software">Software</option>
                  <option value="Law">Law</option>
                  <option value="Human Resource">Human Resource</option>
                  <option value="Operation">Operation</option>
                  <option value="Marketing">Marketing</option>
                  <option value="Sales">Sales</option>
                  <option value="Ar-Ge">Ar-Ge</option>
          </select>
            </td>
        </tr>
        
        <tr>
            <td><b>Department Description</b></td>
            <td><input type='text' name='dep_description' class='form-control' /></td>
            
        </tr>
           <tr>
            <td><b>Meeting Name</b></td>
            <td><input type='text' name='meet_name' class='form-control' /></td>
            
        </tr>
           <tr>
            <td><b>Meeting Description</b></td>
            <td><input type='text' name='meet_descrpition' class='form-control' /></td>
            
        </tr>
 
        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Add Employee with Meeting</button>
            </td>
        </tr>
 
    </table>
</form>


<h3>List Of Employees</h3>
<br>
<table class="table table-hover">

    <thead>
      <tr>
        <th><b>Firstname</b></th>
        <th><b>Lastname</b></th>
        <th><b>Salary</b></th>
        <th><b>Department</b></th>
        <th><b>Department Description</b></th>
        <th><b>Transactions</b></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${listofemployee}" var="loe">
      <tr>
        <td><c:out value="${loe.emp.emp_name}"></c:out></td>
        <td><c:out value="${loe.emp.emp_surname}"></c:out></td>
        <td><c:out value="${loe.emp.emp_salary}"></c:out></td>
         <td><c:out value="${loe.dep_name}"></c:out></td>
          <td><c:out value="${loe.dep_description}"></c:out></td>

            <td>
             <a href="delete/${loe.emp.emp_id}">
                <button type="submit" class="btn btn-primary">Delete</button>
                </a>
            </td>
      </tr>

          </c:forEach>
    </tbody>
  </table>

</div>

</body>
</html>