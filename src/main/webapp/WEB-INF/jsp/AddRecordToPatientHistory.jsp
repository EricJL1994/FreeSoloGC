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
                        <span class="highlight">Records</span>
                    </div>
                    <div class="card-body">
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
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                    <c:if test="${!empty records}">
                                            <c:forEach items="${records}" var="record">
                                                <tr>
                                                    <td><c:out value="${record.centre}"/></td>
                                                    <td><c:out value="${record.tests}"/></td>
                                                    <td><c:out value="${record.symptoms}"/></td>
                                                    <td><c:out value="${record.diagnosis}"/></td>
                                                    <td><c:out value="${record.date}"/></td>
                                                    <td><c:out value="${record.treatment}"/></td>
                                                    <td><c:out value="${record.observations}"/></td>
                                                    <td>
                                                        <a href=<c:out value="record/${record.id}/prescriptions" /> >
                                                            <button type="button" class="btn btn-info"><i class="fa fa-plus"></i></button>
                                                        </a>
                                                    </td>
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
                       <div class="card-header">Add new record</div>
                       <div class="card-body">
                           <form class="form form-horizontal" action="/doctors/patients/${patientId}/history/new" method="post">
                               <div class="section">
                                   <div class="section-title">Information</div>
                                   <div class="section-body">
                                       <div class="form-group">
                                           <label class="col-md-3 control-label">Centre</label>
                                           <div class="col-md-9">
                                               <input class="form-control" name="centre"  placeholder="Medical centre" type="text" required>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <div class="col-md-3">
                                               <label class="control-label">Symptoms</label>
                                           </div>
                                           <div class="col-md-9">
                                               <textarea class="form-control" name="symptoms"  required></textarea>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <div class="col-md-3">
                                               <label class="control-label">Tests</label>
                                           </div>
                                           <div class="col-md-9">
                                               <textarea class="form-control" name="tests" required></textarea>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label class="col-md-3 control-label">Date</label>
                                           <div class="col-md-9">
                                               <input class="form-control" placeholder="dd/mm/yyyy" type="text" name="date" required>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                               <div class="section">
                                   <div class="section-title">Diagnosis and Treatment</div>
                                   <div class="section-body">
                                       <div class="form-group">
                                           <div class="col-md-3">
                                               <label class="control-label">Diagnosis</label>
                                           </div>
                                           <div class="col-md-9">
                                               <textarea class="form-control" name="diagnosis" required></textarea>
                                           </div>
                                       </div>

                                       <div class="form-group">
                                           <div class="col-md-3">
                                               <label class="control-label">Treatment</label>
                                           </div>
                                           <div class="col-md-9">
                                               <textarea class="form-control" name="treatment" required></textarea>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <div class="col-md-3">
                                               <label class="control-label">Observations</label>
                                           </div>
                                           <div class="col-md-9">
                                               <textarea class="form-control" name="observations" required></textarea>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                               <div class="form-footer">
                                   <div class="form-group">
                                       <div class="col-md-9 col-md-offset-3">
                                           <button type="submit" class="btn btn-primary">Save record</button>
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