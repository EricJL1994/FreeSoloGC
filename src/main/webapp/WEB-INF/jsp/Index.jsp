<!DOCTYPE html>
<html>
<head>
    <title>Medical History</title>

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
                    <a href="#services">
                        <div class="icon">
                            <i class="fa fa-cloud" aria-hidden="true"></i>
                        </div>
                        <div class="title">Services</div>
                    </a>
                </li>
                <li class="">
                    <a href="#about">
                        <div class="icon">
                            <i class="fa fa-child" aria-hidden="true"></i>
                        </div>
                        <div class="title">About Us</div>
                    </a>
                </li>
            </ul>
        </div>
        <jsp:include page="LogoutButton.jsp"/>
    </aside>

    <a name="top"></a>
    <div class="app-container">
        <div class="row">
            <div class="col-lg-10">
                <div class="container">

                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title text-center">
                                    Doctors
                                </div>
                            </div>
                            <div class="card-body text-center">
                                <img src="../../images/Doctor-index.png" alt="Doctor image" class="img-circle"
                                     width="140" height="140">
                                <br>
                                <p>As a doctor you can manage all yours patients history.</p>
                                <p>
                                    <a class="btn btn-secondary" href="/login" role="button">Log in</a>
                                    OR
                                    <a class="btn btn-secondary" href="/doctors" role="button">Sign up</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title text-center">
                                    Pharmacies
                                </div>
                            </div>

                            <div class="card-body text-center">
                                <img src="../../images/Pharmacy-index.png" alt="Doctor image" class="img-circle"
                                     width="140" height="140">
                                <p>As a pharmacy you can see what medication your client needs.</p>
                                <p>
                                    <a class="btn btn-secondary" href="#Comming Soon" role="button">Log in</a>
                                    OR
                                    <a class="btn btn-secondary" href="/pharmacies" role="button">Sign up</a>
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title text-center">Patients</div>
                            </div>

                            <div class="card-body text-center">
                                <img src="../../images/Patient-index.png" alt="Doctor image" class="img-circle"
                                     width="140" height="140">
                                <p>As a patient you can see your medical history, recipes or appointments.</p>
                                <p>
                                    <a class="btn btn-secondary" href="/login" role="button">Log in</a>
                                    OR
                                    <a class="btn btn-secondary" href="/patients" role="button">Sign up</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <a name="services"></a>
        <div class="row">
            <div class="col-lg-12">
                <div class="container center-block card">
                    <div class="card-header">
                        <div class="card-title">
                            Our Services
                        </div>
                    </div>
                    <div class="card-body">
                        <p>Nowadays you can register on our service, see yours and doctors profile.</p>
                    </div>
                </div>
            </div>
        </div>

        <a name="about"></a>
        <div class="row">
            <div class="col-lg-12">
                <div class="container center-block card">
                    <div class="card-header">
                        <div class="card-title">
                            Who are we?
                        </div>
                    </div>
                    <div class="card-body">
                        <p>We are a group of students from the ULPGC.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="Footer.jsp"/>