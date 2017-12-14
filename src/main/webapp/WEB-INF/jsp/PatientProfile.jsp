<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.medicalHistory.model.Patient" %>
<jsp:include page="PatientHeader.jsp"/>
<div class="app-container">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container-fluid">
            <div class="navbar-collapse collapse in">
                <ul class="nav navbar-nav navbar-mobile">
                    <li>
                        <button type="button" class="sidebar-toggle">
                            <i class="fa fa-bars"></i>
                        </button>
                    </li>
                    <li class="logo">
                        <a class="navbar-brand" href="#"><span class="highlight">Flat v3</span> Admin</a>
                    </li>
                    <li>
                        <button type="button" class="navbar-toggle">
                            <img class="profile-img" src="images/profile.png">
                        </button>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-left">
                    <li class="navbar-title">Profile</li>
                    <form method="GET" action="/findDoctor" class="navbar-search hidden-sm">
                        <input name="doctorName" type="text" placeholder="Search doctor...">
                        <button type="submit" class="btn-search"><i class="fa fa-search"></i></button>
                    </form>
                </ul>
            </div>
        </div>
    </nav>
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <div class="card-body app-heading">
                    <img class="profile-img" src="images/profile.png">
                    <div class="app-title">
                        <div class="title">
                            <span class="highlight">
                                <% out.print(((Patient)request.getAttribute("user")).getName()); %>
                            </span>
                        </div>
                        <div class="description">
                            <% out.print(((Patient)request.getAttribute("user")).getSurname()); %>
                        </div>
                        <div class="description">
                            <% out.print(((Patient)request.getAttribute("user")).getPhone()); %>
                        </div>
                        <div class="description">
                            <% out.print(((Patient)request.getAttribute("user")).getDateofbirth()); %>
                        </div>
                        <div class="description">
                            <% out.print(((Patient)request.getAttribute("user")).getDni()); %>
                        </div>
                        <div class="description">
                            <% out.print(((Patient)request.getAttribute("user")).getGender()); %>
                        </div>
                        <div class="description">
                            <% out.print(((Patient)request.getAttribute("user")).getAddress()); %>
                        </div>
                        <div class="description">
                            <% out.print(((Patient)request.getAttribute("user")).getEmail()); %>
                        </div>
                        <div class="description">
                            <a class="btn btn-primary" href="/editPatient">Edit</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp" />