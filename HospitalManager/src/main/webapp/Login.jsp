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
                                    <a href="Forget.jsp" style="color: #333333;text-decoration: underline;font-weight: bold">Forgot password?</a>
                                </div>

                                <!-- Submit button -->
                                <button type="submit" class="btn btn-primary btn-lg btn-block" style="background-color: #58bc79;color: white">Sign in</button>

                                <div class="divider d-flex align-items-center my-4">
                                    <p class="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
                                </div>
                                <center>
                                    <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account?   
                                        <a href="Register.jsp" style="background-color: red" class="btn btn-primary">Register</a>
                                    </p>
                                </center>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </body>
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
