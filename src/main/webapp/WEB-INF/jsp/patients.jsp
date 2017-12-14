<!DOCTYPE HTML>
<html>
<head>
    <title>Patients</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/vendor.css">
    <link rel="stylesheet" type="text/css" href="css/flat-admin.css">
</head>
<body>
<div class="app app-default">
    <div class="app-container app-login">
        <div class="flex-center">
            <div class="app-header"></div>
            <div class="app-body">
                <div class="app-block">
                    <div class="app-form">
                        <div class="form-suggestion">
                            Register a new patient.
                        </div>
                        <form action="/patients" method="post">
                            <div>
                                <%if (request.getAttribute("error") != null) {%>
                                    <span style="color:red"><%=request.getAttribute("error")%></span>
                                <%}%>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="name" name="name" class="form-control" placeholder="Name"  required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon2">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="surname" name="surname" class="form-control" placeholder="Surname" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon3">
                                    <i class="fa fa-key" aria-hidden="true"></i>
                                </span>
                                <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon4">
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="phone" name="phone" class="form-control" placeholder="Phone" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon5">
                                    <i class="fa fa-calendar" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="dateofbirth" name="dateofbirth" class="form-control" placeholder="Date of Birth" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon6">
                                    <i class="fa fa-credit-card" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="dni" name="dni" class="form-control" placeholder="DNI" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon7">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="gender" name="gender" class="form-control" placeholder="Gender" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon8">
                                    <i class="fa fa-home" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="address" name="address" class="form-control" placeholder="Address" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon9">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="email" name="email" class="form-control" placeholder="Email" required>
                            </div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-success btn-submit" value="Register">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="app-footer">
            </div>
        </div>
    </div>
</div>
</body>
</html>