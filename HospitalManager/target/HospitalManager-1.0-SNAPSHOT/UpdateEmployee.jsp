<%-- 
    Document   : UpdateEmployee
    Created on : Mar 18, 2024, 5:33:25 PM
    Author     : MSI Bravo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
        }

        .section-title {
            text-align: center;
            margin-bottom: 30px;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        table td:first-child {
            width: 30%;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: calc(100% - 6px);
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<section id="book-a-table" class="menu section-bg">
    <div class="container" data-aos="fade-up">

        <div class="section-title">
            <h2>Update</h2>
        </div>
        <form action="updateemployee" method="post" class="update11">
            <table>
                <tr>
                    <td>ID</td>
                    <td>
                        <input value="${stt.id}" type="text" name="id" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Full Name</td>
                    <td>
                        <input value="${stt.fullname}" type="text" name="fullname">
                    </td>
                </tr>
                <tr>
                    <td>Date Of Birth</td>
                    <td><input value="${stt.dob}" type="datetime-local" name="dob"></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <select name="gender">
                            <option value="1" ${stt.gender == true ? "selected" : ""}>Nam</option>
                            <option value="0" ${stt.gender == false ? "selected" : ""}>Nữ</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input value="${stt.address}" type="text" name="address"></td>
                </tr>
                <tr>
                    <td>PhoneNumber</td>
                    <td><input value="${stt.phonenumber}" type="text" name="phonenumber"></td>
                </tr>
                <tr>
                    <td>User ID</td>
                    <td><input value="${stt.user_id}" type="text"  name="user_id" ></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Update</button></td>
                </tr>
            </table>
        </form>
    </div>
</section> End Menu Section 
</body>
</html>-->

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Thêm nhân viên | Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <script>

            function readURL(input, thumbimage) {
                if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("#thumbimage").attr('src', e.target.result);
                    }
                    reader.readAsDataURL(input.files[0]);
                } else { // Sử dụng cho IE
                    $("#thumbimage").attr('src', input.value);

                }
                $("#thumbimage").show();
                $('.filename').text($("#uploadfile").val());
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'default');
                $(".removeimg").show();
                $(".Choicefile").unbind('click');

            }
            $(document).ready(function () {
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();

                });
                $(".removeimg").click(function () {
                    $("#thumbimage").attr('src', '').hide();
                    $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                    $(".removeimg").hide();
                    $(".Choicefile").bind('click', function () {
                        $("#uploadfile").click();
                    });
                    $('.Choicefile').css('background', '#14142B');
                    $('.Choicefile').css('cursor', 'pointer');
                    $(".filename").text("");
                });
            })
        </script>
    </head>

    <body class="app sidebar-mini rtl">
        <style>
            .Choicefile {
                display: block;
                background: #14142B;
                border: 1px solid #fff;
                color: #fff;
                width: 150px;
                text-align: center;
                text-decoration: none;
                cursor: pointer;
                padding: 5px 0px;
                border-radius: 5px;
                font-weight: 500;
                align-items: center;
                justify-content: center;
            }

            .Choicefile:hover {
                text-decoration: none;
                color: white;
            }

            #uploadfile,
            .removeimg {
                display: none;
            }

            #thumbbox {
                position: relative;
                width: 100%;
                margin-bottom: 20px;
            }

            .removeimg {
                height: 25px;
                position: absolute;
                background-repeat: no-repeat;
                top: 5px;
                left: 5px;
                background-size: 25px;
                width: 25px;
                /* border: 3px solid red; */
                border-radius: 50%;

            }

            .removeimg::before {
                -webkit-box-sizing: border-box;
                box-sizing: border-box;
                content: '';
                border: 1px solid red;
                background: red;
                text-align: center;
                display: block;
                margin-top: 11px;
                transform: rotate(45deg);
            }

            .removeimg::after {
                /* color: #FFF; */
                /* background-color: #DC403B; */
                content: '';
                background: red;
                border: 1px solid red;
                text-align: center;
                display: block;
                transform: rotate(-45deg);
                margin-top: -2px;
            }
        </style>
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="/index.html"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="/images/hay.jpg" width="50px"
                                                alt="User Image">
                <div>
                    <p class="app-sidebar__user-name"><b>...</b></p>
                    <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item haha" href="phan-mem-ban-hang.html"><i class='app-menu__icon bx bx-cart-alt'></i>
                        <span class="app-menu__label">POS Bán Hàng</span></a></li>
                <li><a class="app-menu__item " href="index.html"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>
                <li><a class="app-menu__item active" href="loadem"><i class='app-menu__icon bx bx-id-card'></i>
                        <span class="app-menu__label">Quản lý nhân viên</span></a></li>

            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">Danh sách nhân viên</li>
                    <li class="breadcrumb-item"><a href="#">Thêm nhân viên</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">

                    <div class="tile">

                        <h3 class="tile-title">Update nhân viên</h3>
                        <div class="tile-body">
                            <!--            <div class="row element-button">
                                          <div class="col-sm-2">
                                            <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#exampleModalCenter"><b><i
                                                  class="fas fa-folder-plus"></i> Tạo chức vụ mới</b></a>
                                          </div>
                            
                                        </div>-->
                            <form action="updateemployee" method="post" class="row">
                                <div class="form-group col-md-6">
                                    <label class="control-label">ID</label>
                                    <input class="form-control" value="${stt.id}" type="text" name="id" readonly>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="control-label">Full Name</label>
                                    <input class="form-control" value="${stt.fullname}" type="text" name="fullname">
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="control-label">Date Of Birth</label>
                                    <input class="form-control" value="${stt.dob}" type="datetime-local" name="dob" required>
                                </div>
                               
                                <div class="form-group col-md-6">
                                    <label class="control-label">Address</label>
                                    <input class="form-control" value="${stt.address}" type="text" name="address" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="control-label">PhoneNumber</label>
                                    <input class="form-control" value="${stt.phonenumber}" type="text" name="phonenumber" required>
                                </div>
                                <div class="form-group  col-md-3">
                                    <label class="control-label">User Id</label>
                                    <input class="form-control" value="${stt.user_id}" type="number" name="user_id" required>
                                </div>
                                 <div class="form-group col-md-3">
                                    <label class="control-label">Giới tính</label>
                                    <select class="form-control" id="exampleSelect2" name="gender" required>
                                        <option>-- Chọn giới tính --</option>
                                        <option value="1" ${stt.gender == true ? "selected" : ""}>Nam</option>
                                        <option value="0" ${stt.gender == false ? "selected" : ""}>Nữ</option>
                                    </select>
                                </div>
                                <tr>

                                <button class="btn btn-save" type="submit">Update</button>
                                <a class="btn btn-cancel" href="index.html">Hủy bỏ</a>

                            </form>

                        </div>

                    </div>

                    </main>


                    <!--
                    MODAL
                    -->
                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
                         data-backdrop="static" data-keyboard="false">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">

                                <div class="modal-body">
                                    <div class="row">
                                        <div class="form-group  col-md-12">
                                            <span class="thong-tin-thanh-toan">
                                                <h5>Tạo chức vụ mới</h5>
                                            </span>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <label class="control-label">Nhập tên chức vụ mới</label>
                                            <input class="form-control" type="text" required>
                                        </div>
                                    </div>
                                    <BR>
                                    <button class="btn btn-save" type="button">Lưu lại</button>
                                    <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                                    <BR>
                                </div>
                                <div class="modal-footer">
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--
                    MODAL
                    -->


                    <!-- Essential javascripts for application to work-->
                    <script src="js/jquery-3.2.1.min.js"></script>
                    <script src="js/popper.min.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                    <script src="js/main.js"></script>
                    <!-- The javascript plugin to display page loading on top-->
                    <script src="js/plugins/pace.min.js"></script>

                    </body>

                    </html>