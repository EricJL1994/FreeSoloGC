<%@ page import="com.medicalHistory.model.Pharmacy" %>
<jsp:include page="Header.jsp"/>
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

                        <form method="GET" action="/findPatient" class="navbar-search hidden-sm">
                            <input name="patientName" type="text" placeholder="Search patient...">
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
                        <img class="profile-img" src="images/farmacia.png">
                        <div class="app-title">
                            <div class="title">
                                <span class="highlight">
                                    <% out.print(((Pharmacy)request.getAttribute("pharmacy")).getName()); %>
                                </span>
                            </div>
                            <div class="description">
                                 <% out.print(((Pharmacy)request.getAttribute("pharmacy")).getNif()); %>
                            </div>
                            <div class="description">
                                 <% out.print(((Pharmacy)request.getAttribute("pharmacy")).getAddress()); %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="Footer.jsp" />