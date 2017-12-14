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
                    <li class="navbar-search hidden-sm">
                        <input id="search" type="text" placeholder="Search..">
                        <button class="btn-search"><i class="fa fa-search"></i></button>
                    </li>
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
                        <form action="/updatePatient" method="POST">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="name" name="name" class="form-control" placeholder="Name" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getName()); %>"  required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon2">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="surname" name="surname" class="form-control" placeholder="Surname" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getSurname()); %>" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon3">
                                    <i class="fa fa-key" aria-hidden="true"></i>
                                </span>
                                <input type="password" id="password" name="password" class="form-control" placeholder="Password" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getPassword()); %>" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon4">
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="phone" name="phone" class="form-control" placeholder="Phone" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getPhone()); %>" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon5">
                                    <i class="fa fa-calendar" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="dateofbirth" name="dateofbirth" class="form-control" placeholder="Date of Birth" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getDateofbirth()); %>" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon6">
                                    <i class="fa fa-credit-card" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="dni" name="dni" class="form-control" placeholder="DNI" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getDni()); %>" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon7">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="gender" name="gender" class="form-control" placeholder="Gender" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getGender()); %>" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon8">
                                    <i class="fa fa-home" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="address" name="address" class="form-control" placeholder="Address" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getAddress()); %>" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon9">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="email" name="email" class="form-control" placeholder="Email" value="<% out.print(((Patient)request.getSession().getAttribute("user")).getEmail()); %>" required>
                            </div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-success btn-submit" value="Save">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp" />