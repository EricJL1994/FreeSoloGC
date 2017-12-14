<!DOCTYPE HTML>
<html>
<head>
    <title>Pharmacies</title>
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
                            Register a new pharmacy.
                        </div>
                        <form action="/pharmacies" method="post">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="nif" name="nif" class="form-control" placeholder="NIF"  required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon2">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="name" name="name" class="form-control" placeholder="Name" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon8">
                                    <i class="fa fa-home" aria-hidden="true"></i>
                                </span>
                                <input type="text" id="address" name="address" class="form-control" placeholder="Address" required>
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