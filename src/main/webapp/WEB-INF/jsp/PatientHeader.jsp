<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.medicalHistory.model.Patient" %>
<!DOCTYPE html>
<html>
<head>
    <title>Medical History patient profile</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="css/vendor.css">
    <link rel="stylesheet" type="text/css" href="css/flat-admin.css">

</head>
<body>
<div class="app app-default">
    <aside class="app-sidebar" id="sidebar">
        <div class="sidebar-header">
            <a class="sidebar-brand" href="/"><span class="highlight">Medical history</span></a>
            <button type="button" class="sidebar-toggle">
                <i class="fa fa-times"></i>
            </button>
        </div>
        <div class="sidebar-menu">
            <ul class="sidebar-nav">
                <li class="">
                    <a href="/">
                        <div class="icon">
                            <i class="fa fa-dashboard" aria-hidden="true"></i>
                        </div>
                        <div class="title">Dashboard</div>
                    </a>
                </li>
                <li class="">
                    <% out.print("<a href=\"/doctors/patients/" + ((Patient)request.getAttribute("user")).getId() + "/history\">"); %>
                        <div class="icon">
                            <i class="fa fa-file-text" aria-hidden="true"></i>
                        </div>
                        <div class="title">View history</div>
                    </a>
                </li>
            </ul>
        </div>
        <jsp:include page="LogoutButton.jsp"/>
    </aside>