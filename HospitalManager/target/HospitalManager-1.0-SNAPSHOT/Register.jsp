<%-- 
    Document   : Register
    Created on : Mar 5, 2024, 9:42:23 AM
    Author     : FPT SHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
        <!--CSS-->
        <style>

            .text{
                font-family: monospace;
                font-weight: bold;
            }

        </style>
    </head>
    <body>
        <section class="vh-100 bg-image" 
                 style="background-color: #15bcc2;">
            <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                <div class="container h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div class="card" style="border-radius: 15px;">
                                <div class="card-body p-5">

                                    <!-- Title -->
                                    <h2 class="text-uppercase text" style="text-align: center">Create an account</h2>
                                    <h2 style="text-align: center;font-size: 20px;color: red">${messError}</h2>
                                    <!-- body-->
                                    <form action="Register" method="get" name="Form" onsubmit="return validateInput() && validatePassword();"> 

                                        <div style="display: inline-flex">

                                            <!-- body left-->
                                            <div style="float: left;width: 50%;margin-left: 20px" >
                                                <div class="form-outline ">
                                                    <label class="form-label text" for="form3Example1cg">First Name</label><br>
                                                    <input type="text" name="first_name"/>
                                                </div>

                                                <div class="form-outline ">
                                                    <label class="form-label text" for="form3Example1cg">Password</label><br>
                                                    <input type="password" name="password"/>
                                                </div>

                                                <div class="form-outline ">
                                                    <label class="form-label text" for="form3Example1cg">Email</label><br>
                                                    <input type="email" name="email"/>
                                                </div><!-- comment -->

                                                <div class="form-outline " style="padding-top: 10px;">
                                                    <label class="form-label text" for="form3Example1cg">You are</label>
                                                    <select name="role">  
                                                        <option value="1">Patient</option>
                                                        <option value="2">Doctor</option>
                                                        <option value="3">Employee</option>
                                                    </select>
                                                </div><!-- comment -->
                                            </div>
                                            <!-- body right-->
                                            <div style="float: right;width: 50%;margin-left: 100px">
                                                <div class="form-outline ">
                                                    <label class="form-label text" for="form3Example1cg">Last Name</label><br>
                                                    <input type="text" name="last_name"/>
                                                </div>

                                                <div class="form-outline ">
                                                    <label class="form-label text" for="form3Example1cg">Retype Password</label><br>
                                                    <input type="password" name="password2"/>
                                                </div>

                                                <div class="form-outline ">
                                                    <label class="form-label text" for="form3Example1cg">Retype Email</label><br>
                                                    <input type="email" name="email2"/>
                                                </div><!-- comment -->
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-center" style="margin-top: 30px">
                                            <input type="submit" name="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" style="font-size: 20px">
                                        </div>
                                        <p class="text-center text-muted mt-5 mb-0">Have already an account? 
                                            <a href="Login.jsp" class="fw-bold text-body"><u>Login here</u></a>
                                        </p>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>
        <script>
            function validateInput() {
                var firstname = document.forms["Form"]["firstname"].value;
                var lastname = document.forms["Form"]["lastname"].value;
                var phone = document.forms["Form"]["phone"].value;
                var password = document.forms["Form"]["password"].value;
                var password2 = document.forms["Form"]["password2"].value;
                var email = document.forms["Form"]["email"].value;
                var email2 = document.forms["Form"]["email2"].value;
                var gender = document.getElementsByName('gender');
                var address = document.forms["Form"]["address"].value;
                if (password !== password2) {
                    alert("Password does not match");
                    return false;
                }
                if (email !== email2) {
                    alert("Email does not match");
                    return false;
                }
                if (
                        firstname === "" ||
                        lastname === "" ||
                        phone === "" ||
                        password === "" ||
                        password2 === "" ||
                        email === "" ||
                        email2 === "" ||
                        gender.length === 0 ||
                        address === ""
                        ) {
                    alert("Please fill in all required fields");
                    return false;
                }
            }
            function validatePassword() {
                var password = document.forms["Form"]["password"].value;
                var password2 = document.forms["Form"]["password2"].value;
                var validate = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
                if (!validate.test(password) || !validate.test(password2)) {
                    alert("Please enter a password with at least 8 letters, a symbol, 1 uppercase and lowercase letter, and 1 number");
                    return false;
                }
            }
        </script>        
    </body>
</html>
