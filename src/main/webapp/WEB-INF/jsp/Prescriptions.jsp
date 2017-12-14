<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <form method="GET" action="/findDoctor" class="navbar-search hidden-sm">
                            <input name="doctorName" type="text" placeholder="Search doctor...">
                            <button type="submit" class="btn-search"><i class="fa fa-search"></i></button>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
       <div class="row">
            <div class="col-cs-12">
                <div class="card">
                    <div class="card-header">
                        <span class="highlight">Record and prescriptions</span>
                    </div>
                    <div class="card-body">
                        <h2><span class="highlight">Record</span></h2>
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-striped table-bordered table-hover col-md-12">
                                    <thead>
                                    <tr>
                                        <th>Centre</th>
                                        <th>Tests</th>
                                        <th>Symptoms</th>
                                        <th>Diagnosis</th>
                                        <th>Date</th>
                                        <th>Treatment</th>
                                        <th>Observations</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${record.centre}</td>
                                            <td>${record.tests}</td>
                                            <td>${record.symptoms}</td>
                                            <td>${record.diagnosis}</td>
                                            <td>${record.date}</td>
                                            <td>${record.treatment}</td>
                                            <td>${record.observations}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <h2><span class="highlight">Prescriptions</span></h2>
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-striped table-bordered table-hover col-md-12">
                                    <thead>
                                        <tr>
                                            <th>Dose</th>
                                            <th>Medicament</th>
                                            <th>Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:if test="${!empty prescriptions}">
                                            <c:forEach items="${prescriptions}" var="prescription">
                                                <tr>
                                                    <td><c:out value="${prescription.medicament}"/></td>
                                                    <td><c:out value="${prescription.dose}"/></td>
                                                    <td><c:out value="${prescription.date}"/></td>
                                                </tr>
                                            </c:forEach>
                                        </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           <c:if test="${isADoctor}">
               <div class="col-cs-12">
                   <div class="card">
                       <div class="card-header">Add new prescription</div>
                       <div class="card-body">
                           <form class="form form-horizontal" action="/addPrescription" method="post">
                               <div class="section">
                                   <div class="section-title">Prescription</div>
                                   <div class="section-body">
                                       <div class="form-group">
                                           <label class="col-md-3 control-label">Medicament</label>
                                           <div class="col-md-9">
                                               <input class="form-control" name="Medicament"  placeholder="Medicament" type="text" required>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <div class="col-md-3">
                                               <label class="control-label">Dose</label>
                                           </div>
                                           <div class="col-md-9">
                                               <input class="form-control" name="Dose"  placeholder="ej: 200 mg" type="text" required>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label class="col-md-3 control-label">Date</label>
                                           <div class="col-md-9">
                                               <input class="form-control" placeholder="dd/mm/yyyy" type="text" name="date" required>
                                           </div>
                                       </div>
                                       <input type="hidden" name="recordId" value="${recordId}"/>
                                       <input type="hidden" name="patientId" value="${patientId}"/>
                                   </div>
                               </div>
                               <div class="form-footer">
                                   <div class="form-group">
                                       <div class="col-md-9 col-md-offset-3">
                                           <button type="submit" class="btn btn-primary">Add prescription</button>
                                       </div>
                                   </div>
                               </div>
                           </form>
                       </div>
                   </div>
               </div>
           </c:if>
       </div>
    </div>
<jsp:include page="Footer.jsp" />