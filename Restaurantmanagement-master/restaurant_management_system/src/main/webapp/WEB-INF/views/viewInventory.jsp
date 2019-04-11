<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored ="false"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
      <%            
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>Inventory List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
        crossorigin="anonymous">


    <style>
        /* .tablist{
    text-align: center;
    text-decoration: none;
    font-size: 4mm;
    color: rgb(43, 43, 43);
    border-bottom: rgb(202, 202, 202) 1px solid;
    border-right: rgb(202, 202, 202) 1px solid;
    background-color: inherit;
    width: 20px;
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
   
} */
</style>

<script type="text/javascript">
	function handleSelect(elm)
	{
		
	window.location = elm.value;
	}
</script>
</head>

<body background="resources/css/bg.jpg">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#" style="font-size:7mm;">Foodster</a>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        Inventory
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="viewInventory.html">View Inventory List</a>
                        <a class="dropdown-item" href="addInventory.html">Add Inventory</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        Staff
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="viewStaff.html">View Staff List</a>
                        <a class="dropdown-item" href="addStaff.html">Add Staff</a>
                    </div>
                </li>
            </ul>
            <span class="navbar-text">
                <a href="signOut.html" class="nav-link">
                    <span class="fas fa-sign-out-alt"></span>
                    Sign out
                </a>
            </span>
        </div>
    </nav>

    <div style="font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;margin:30px;">
        <div class="row">
            <div class="col-md-3 bg-dark">
                <br>
                <span>
                    <h4 style="color:white">Profile</h4>
                </span>
                <br>
                <center>
                    <br>
                    <br>
                    <b style="color:white">${employee.firstName} ${employee.lastName}
                    </b>
                    <br>
                    <br>
                    <p style="color:white">Age: ${employee.age}</p>
                    <br>
                    <br>
                    <p style="color:white">
                        Gender:

                        ${employee.gender}
                    </p>
                    <br>
                    <br>
                    <p style="color:white">
                        Contact:
                        ${employee.contactNumber}
                    </p>
                    <br>
                </center>
            </div>

            <div class="col-md-9" style="background-color: rgba(182, 182, 182, 0.7)">
                    <div class="container">
                            <div class="row">
                                <select name="sorting" onchange="location = this.value;" class="btn btn-dark col-md-2 p-0 m-2 mr-5">
                                    <option value="">Sorting Type-Total Stock</option>
                                    <option value="sortInventory.html?order=LTH">Low To High</option>
                                    <option value="sortInventory.html?order=HTL">High To Low</option>
                                </select>
                    
                            
                                        <form class="col-6 m-2 d-inline" style="height:17px;" action="searchInventory.html" method="POST">
                                    <div class="input-group">
                                        
                                            <input type="text" class="form-control" name="name" placeholder="Search by Name" aria-label="Recipient's username"
                                                aria-describedby="button-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-dark ml-0" type="submit" id="button-addon2">Go</button>
                                            </div>
                                        
                                    </div>
                                </form>
                               
                    
                                <a href="addInventory.html" class="btn btn-dark col-md-2 p-2 m-2 ml-5">Add
                                    Inventory</a>
                            </div>
                    
                    
                     
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-sm" cellspacing="0" width="100%" style="margin-top:30px">
                        <thead>
                            <th class="th-sm" style="background-color:inherit; color: rgb(43, 43, 43)">Inventory Id</th>
                            <th class="th-sm" style="background-color: inherit; color: rgb(43, 43, 43)">Name</th>
                            <th class="th-sm" style="background-color: inherit; color: rgb(43, 43, 43)">Creation Date</th>
                            <th class="th-sm" style="background-color: inherit; color: rgb(43, 43, 43)">Start Date</th>
                            <th class="th-sm" style="background-color: inherit; color: rgb(43, 43, 43)">End Date</th>
                            <th class="th-sm" style="background-color: inherit; color: rgb(43, 43, 43)">Total Stock</th>
                            <th class="th-sm" style="background-color: inherit; color: rgb(43, 43, 43); border-right: none; border-left: rgb(202, 202, 202) 1px solid"></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${inventorys}" var="inventory">

                                <tr>
                                    <td><font color="black">${inventory.inventoryId}</font></td>
                                    <td><font color="black">${inventory.inventoryName}</font></td>
                                    <td><font color="black">${inventory.creationDate}</font></td>
                                    <td><font color="black">${inventory.startDate}</font></td>
                                    <td><font color="black">${inventory.endDate}</font></td>
                                    <td><font color="black">${inventory.totalStock}</font></td>
                                
                                    <td style="border-right: none; border-left: rgb(202, 202, 202) 1px solid; width:300px;">
                                        <div class="btn-group" role="group" aria-label="Basic example">
                                        
                                            <a href="editInventory.html?id=${inventory.inventoryId}" class="btn btn-secondary"><i
                                                    class="fas fa-edit"></i></a>
                                                
                                            <a href="deleteInventory.html?id=${inventory.inventoryId}" class="btn btn-secondary"><i
                                                    class="fas fa-trash-alt"></i></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>
</body>


</html>