<%-- 
    Document   : Login
    Created on : Mar 5, 2024, 8:10:57 AM
    Author     : FPT SHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href=""/>
            <!-- Font Awesome -->
            <link
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
                rel="stylesheet"
                />
            <!-- Google Fonts -->
            <link
                href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
                rel="stylesheet"
                />
            <!-- MDB -->
            <link
                href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.3.0/mdb.min.css"
                rel="stylesheet"
                />
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
            <style>
                .divider:after,
                .divider:before {
                    content: "";
                    flex: 1;
                    height: 1px;
                    background: #eee;
                }
                .loginTitle{
                    font-family: monospace;
                    font-size:20px;
                    margin-bottom: 20px;
                    font-weight: bold;
                }

                .loginTitle2{
                    font-family: monospace;
                    font-size:30px;
                    margin-bottom: 20px;
                    font-weight: bold;
                }
            </style>

        </head>
        <body>
            <section class="vh-100" style="background-color: #15bcc2">
                <div class="container py-5 h-100">
                    <div class="row d-flex align-items-center justify-content-center h-100">
                        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                            <form action="Login" method="post" name="FORM" onsubmit="return validateInput() && validatePassword();">

                                <!-- title -->
                                <div>
                                    <center>
                                        <label class="loginTitle">Welcome to 
                                            <p class="loginTitle2">E-Hospital</p>
                                            <p style="color: red;font-family: monospace;font-size: 20px">${errorMessage}</p>
                                        </label>
                                    </center>
                                </div>

                                <!-- Email input -->
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form1Example13">Email address</label>
                                    <input name="email" type="email" style="background-color: white" id="form1Example13" class="form-control form-control-lg" />

                                </div>

                                <!-- Password input -->
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form1Example23">Password</label>
                                    <input name="password" type="password" style="background-color: white" id="form1Example23" class="form-control form-control-lg" />

                                </div>

                                <div class="d-flex justify-content-around align-items-center mb-4">
                                    <!-- Checkbox -->
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
                                        <label class="form-check-label" for="form1Example3"> Remember me </label>
                                    </div>
                                    <a href="#" style="color: #333333;text-decoration: underline;font-weight: bold">Forgot password?</a>
                                </div>

                                <!-- Submit button -->
                                <button type="submit" class="btn btn-primary btn-lg btn-block" style="background-color: #58bc79;color: white">Sign in</button>

                                <div class="divider d-flex align-items-center my-4">
                                    <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
                                </div>
                                <center>
                                    <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account?</p>
                                    <div class="dropdown">
                                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Register as a
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="DoctorRegister">Doctor</a>
                                            <a class="dropdown-item" href="EmployeeRegister">Employee</a>
                                            <a class="dropdown-item" href="PatientRegister">Patient</a>
                                        </div>
                                    </div>
                                </center>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </body>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
                                function validateInput() {
                                    var email = document.forms["FORM"]["email"].value;
                                    var password = document.forms["FORM"]["password"].value;
                                    if (email === null || email === "") {
                                        alert("Email must be filled out");
                                        return false;
                                    }
                                    if (password === null || password === "") {
                                        alert("Password must be filled out");
                                        return false;
                                    }
                                    return true;
                                }

                                function validatePassword() {
                                    var password = document.forms["FORM"]["password"].value;
                                    var pattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[\W_]).{8,}$/;
                                    if (!pattern.test(password)) {
                                        alert("Password at least 1 UpperCase, 1 LowerCase, 1 Special Character and more 8 Letters");
                                        return false;
                                    }
                                    return true;
                                }

                                //min 8 letter password, with at least a symbol, upper and lower case letters and a number
                                //John Doe
                                //Dungle101201@

        </script>
    </html>

</body>
</html>
