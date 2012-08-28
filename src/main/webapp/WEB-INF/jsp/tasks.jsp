<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Todo List</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" >
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">

</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            Todo Application
        </div>
    </div>
</div>

<div class="container">
	<div class="row">
		<div class="span8 offset2">
			<div class="page-header">
                <h1>Simple Task Manager</h1>
            </div>
	        <form:form method="post" action="add" commandName="task" class="form-vertical">
                <form:label path="taskName">Task Name</form:label>
                <form:input path="taskName" />
                <form:label path="completeBy">CompleteBy (format: MM/DD/YYYY)</form:label>
                <form:input path="completeBy" />
                <input type="submit" value="Add Person" class="btn"/>
            </form:form>
            <!-- show a list of Tasks here -->
            <c:if test="${!empty taskList}">
            	<h3> Tasks </h3>
            	<table>
            		<thead>
            			<tr>
            				<th>Name</th>
            				<th>Created Date</th>
            			</tr>
            		</thead>
            		<tbody>
            			<c:forEach items="${taskList}" var="task">
            				<tr>
            					<td>${task.taskName}</td>
            					<td>${task.createdDate}</td>
            					<td>
            						<form action="delete/${task.id}" method="post">
            							<input type="submit" class="btn btn-danger btn-mini" value="Delete"/>
            						</form>
            					</td>
            				</tr>
            			</c:forEach>
            		</tbody>
            	</table>
            </c:if>
		</div>
	</div>
</div>
</body>
</html>