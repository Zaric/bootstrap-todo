<!doctype html>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Map"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <meta charset="utf-8">
    <title>Simple Task Manager</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css">

    <style type="text/css">

    </style>
    <!-- /// -->
    <script type="text/javascript">
      <!--
      function appname() {
          return location.hostname.substring(0,location.hostname.indexOf("."));
      }
      // -->
    </script>
  </head>

  <body>
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container" align="center">
          <h2>Simple Task Manager</h2>
        </div>
      </div>
    </div>

    <div class="container">
		<div class="hero-unit" align="center">
				<form name="f"  action="<c:url value='j_spring_security_check' />" method="post">
					<label>User Name</label>
					<input type='text' name='j_username' value=''>
					<label>Password</label>
					<input type='password' name='j_password' />
					<br>
					<input name="submit" type="submit" value="submit" class="btn btn-primary"/>
					<input name="reset" type="reset" class="btn btn-primary"/>
				</form>
				<c:if test="${not empty error}">
					<div class="errorblock">
						Your login attempt was not successful, try again.<br /> Caused :
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</div>
				</c:if>
		</div>
		<div align="center">
		<!--  -->
  		</div>
  	</div>
    <script src="http://twitter.github.com/bootstrap/assets/js/jquery.js"></script>
    <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-modal.js"></script>
    <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-tab.js"></script>
  </body>
</html>
