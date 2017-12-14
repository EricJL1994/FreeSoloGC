<%@ page import="com.medicalHistory.model.Patient" %>
<%@ page import="java.util.Collection" %>

<jsp:include page="Header.jsp"/>
<div class="app-container">
    <div class="row">
        <div class="col-lg-12">
            <div class="card">
                <% Collection<Patient> patients = (Collection<Patient>) request.getAttribute("patients");%>
                <%if (patients.size() == 0) {%>
                <div class="card-body alert-danger">
                    <p class="text-danger">We have no patients assigned yet</p> <br>
                </div>
                <%} else {%>
                <div class="card-header">
                    <div class="card-title">
                        Results
                    </div>
                </div>
                <div class="card-body">
                    <%for (Patient patient : patients) {%>
                        Name: <%=patient.getName() + "  " + patient.getSurname()%>
                        <br>
                        <a class="btn btn-primary" href="<%="/doctors/patients/" + patient.getId() + "/history"%>">See history</a>
                        <br>
                        <br>
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
<jsp:include page="Footer.jsp"/>