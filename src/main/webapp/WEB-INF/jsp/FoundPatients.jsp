<%@ page import="com.medicalHistory.model.Patient" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Found patients</title>

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
                    </li>
                </ul>
            </div>
            <jsp:include page="LogoutButton.jsp"/>
        </aside>
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
                            <li class="navbar-title">Search</li>
                            <li class="">
                                <form action="/findPatient" method="get">
                                    <input name="patientName" type="text" placeholder="patient..">
                                    <input type="submit" class="fa fa-search">
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <%ArrayList<Patient> patientList = (ArrayList<Patient>) request.getAttribute("patientList");%>
                        <%if (patientList.size() == 0){%>
                        <div class="card-body alert-danger">
                            <p class="text-danger">We have not results :( </p> <br>
                        </div>
                        <%}else {%>
                        <div class="card-header">
                            <div class="card-title">
                                Results
                            </div>
                        </div>
                        <div class="card-body">
                            <ul class="list-group">
                                <%for (Patient patient : patientList){%>
                                <li>
                                    <a href="/patient?id=<%=patient.getId()%>"> <%=patient.getName()%>.</a>
                                </li>
                                <%}%>
                            </ul>
                        <%}%>
                            <div class="app-title">
                                <div class="title">
                                    <span class="highlight">
                                    </span>
                                </div>
                                <div class="description">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>