<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
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
                            Login in Medical History
                        </div>
                        <form action="/login" method="POST">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon3">
                                    <i class="fa fa-at" aria-hidden="true"></i>
                                </span>
                                <input type="text" name="email" class="form-control" placeholder="email" required>
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon4">
                                    <i class="fa fa-key" aria-hidden="true"></i>
                                </span>
                                <input type="password" name="password" class="form-control" placeholder="Password" required>
                            </div>

                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon5">

                                </span>
                                <input type="radio" name="userType" value="patient"> Patient<br>
                                <input type="radio" name="userType" value="doctor"> Doctor<br>
                            </div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-success btn-submit" value="Login">
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