<%@ page import="com.medicalHistory.model.Doctor" %>
<%@ page import="com.medicalHistory.model.Patient" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Found doctors</title>

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
                                <form action="/findDoctor" method="get">
                                    <input name="doctorName" type="text" placeholder="doctor..">
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
                        <%ArrayList<Doctor> doctorList = (ArrayList<Doctor>) request.getAttribute("doctorList");%>
                        <%if (doctorList.size() == 0){%>
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
                            <%for (Doctor doctor : doctorList){%>
                                <a href="/doctor?id=<%=doctor.getId()%>"> The doctor <%=doctor.getName()%>, at center <%=doctor.getMedicalCenter()%>.</a>
                                <br>
                                <%if (request.getSession().getAttribute("user") instanceof Patient) {%>
                                    <form action='/assignDoctorToPatient' method='post'>
                                        <input type="text" hidden name="doctorId" value="<%=doctor.getId()%>">
                                        <input type="text" hidden name="patientId" value="<%=((Patient)request.getSession().getAttribute("user")).getId()%>">
                                        <input class="btn btn-primary" type='submit' value="Asignar">
                                    </form>
                                <br><br>
                                <%}%>
                            <%}%>
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