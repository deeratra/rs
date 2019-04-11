<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%            
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
%>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<!-- <html lang="en" class="no-js ie6 lt8">  -->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Foodster Admin Login</title>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
		<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/css.css">
<script type = "text/javascript">
   function validateRegistrationForm(){
	  
	   var firstName = document.forms["registration"]["firstName"].value;
	   var lastName = document.forms["registration"]["lastName"].value;
	   var contactNumber = document.forms["registration"]["contactNumber"].value;
	   var password = document.forms["registration"]["password"].value;
	   var confirmPassword = document.forms["registration"]["confirmPassword"].value;
	  // console.log("gello");
	   if(!(/^[a-zA-z]*$/g.test(firstName))){
		   alert('First Name should be alphabet only');
		  return false;
	   }
	   if(!/^[a-zA-z]*$/g.test(lastName)){
		   alert('Last Name should be alphabet only');
	   return false;
	   } 
	   if(contactNumber.length!=10){
		   alert('Invalid Contact Number');
		   return false;
	   }
	   if(password!=confirmPassword)
		{
		   alert('Password and Confirm Password should match');
		   return false;
	   }
	   alert('Successfully registered');
	   document.forms["registration"].submit();
	   return true; 
   }
   </script>
    </head>
    <body>
    <br><br>
        <div class="container">
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form bg-dark">
                            <form  action="login.html" method="post"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" > Your User Id</label>
                                    <input id="username" name="userId" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd"> Your password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label><div class=col-md-4>
								
                               </div> <p class="login button"> 
                                    <input type="submit" value="Sign in"/> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form><br><br><br>
                           
                        </div>

                        <div id="register" class="animate form bg-dark">
                            <form action="registration.html"  name="registration" onsubmit="return validateRegistrationForm()" method="post"> 
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" >Your User Id</label>
                                    <input id="usernamesignup" name="userId" required="required" type="text" placeholder="mysuperusername690" required/>
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Your asdFirst Name</label>
                                    <input name="firstName" required="required" type="text" placeholder="Charles" required/> 
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Your Last Name</label>
                                    <input name="lastName" required="required" type="text" placeholder="Dickens" required/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" >Your password </label>
                                    <input name="password" required="required" type="password" placeholder="eg. X8df!90EO" required/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" >Please confirm your password </label>
                                    <input  name="confirmPassword" required="required" type="password" placeholder="eg. X8df!90EO" required/>
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Your Gender</label>
                                    <input  name="gender" required="required" type="text" placeholder="mysupermail@mail.com" required/> 
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Your Age</label>
                                    <input name="age" required="required" type="number" placeholder="mysupermail@mail.com" mandatory/> 
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Your Contact Number</label>
                                    <input name="contactNumber" required="required" type="number" placeholder="987654321" mandatory/> 
                                </p>
                                <p class="signin button"> 
                                	<button type="submit" >Sign up</button>
									
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>