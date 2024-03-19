<%-- 
    Document   : UserInformationForAdmin
    Created on : Mar 19, 2024, 10:51:11 PM
    Author     : FPT SHOP
--%>

<%@page import ="dao.UserDAO"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Thông tin người dùng</title>
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

    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="/Dashboard.jsp"/>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">Danh sách người dùng</li>
                    <li class="breadcrumb-item"><a href="#">Thông tin người dùng</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <% User u = (User) request.getAttribute("userinfo"); %>
                        <h3 class="tile-title">Thông tin người dùng</h3>
                        <div class="tile-body">
                            <form action="UserUpdate" method="post">

                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label class="control-label">ID người dùng</label>
                                        <input class="form-control" name="id" value="<%= u.getId() %>" type="text" readonly>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Họ và tên</label>
                                        <input class="form-control" value="<%= u.getFirst_name() %> <%= u.getLast_name() %>" type="text" readonly>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Email</label>
                                        <input class="form-control" value="<%= u.getEmail() %>" type="text" readonly>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Chức vụ</label>
                                        <select class="form-control" name="role">
                                            <option value="4" <%= u.getRole() == 4 ? "selected" : "" %>>Admin</option>
                                            <option value="2" <%= u.getRole() == 2 ? "selected" : "" %>>Employee</option>
                                            <option value="3" <%= u.getRole() == 3 ? "selected" : "" %>>Patient</option>
                                            <option value="1" <%= u.getRole() == 1 ? "selected" : "" %>>Doctor</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label class="control-label">Trạng thái</label>
                                        <select class="form-control" name="status">
                                            <option value="1" <%= u.getStatus() == true ? "selected" : "" %>>Hoạt động</option>
                                            <option value="0" <%= u.getStatus() == false ? "selected" : "" %>>Vô hiệu hóa</option>
                                        </select>
                                    </div>
                                </div>
                                <button class="btn btn-save" type="submit">Lưu lại</button>
                                <a class="btn btn-cancel" href="AdminHome">Hủy bỏ</a>
                            </form>
                        </div>

                    </div>
                </div>

        </main>

        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>

    </body>

</html>

