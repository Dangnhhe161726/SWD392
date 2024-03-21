<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<script>
    function showMess(id) {
        var op = confirm('Bạn chắc chắn muốn xóa?');
        if (op === true) {
            window.location.href = 'deleteemployee?id=' + id;
        }
    }
</script>
</body>
</html>-->


<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Quản lý lịch khám bênh</title>
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

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <jsp:include page="/Dashboard.jsp"/> 
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách lịch khám bệnh</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">

                            <div class="row element-button">
                                <div class="col-sm-2">
                                    <a class="btn btn-excel btn-sm" href="./medicalhistory" title="In">Return</a>
                                </div>
                            </div>
                            <div class="tile-body">

                                <form action="editmedicalhistory" method="post" class="row">
                                    <div class="form-group col-md-6">
                                        <label class="control-label">ID</label>
                                        <input class="form-control" value="${m.id}" type="text" name="id" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label class="control-label">Examination Date</label>
                                        <input class="form-control" value="${m.examinationDate}" type="date" name="examinationDate">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label class="control-label">Diagnosis</label>
                                        <input class="form-control" value="${m.diagnosis}" type="text" name="diagnosis">
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label class="control-label">Prescription</label>
                                        <input class="form-control" value="${m.prescription}" type="text" name="prescription">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label class="control-label">Patient</label>
                                        <select class="form-control" id="exampleSelect2" name="patient">
                                            <c:forEach var="x" items="${listP}">
                                                <option value="${x.id}" ${x.id == m.patient.id ? "selected" : ""}>${x.fullname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group  col-md-3">
                                       <label class="control-label">Doctor</label>
                                        <select class="form-control" id="exampleSelect2" name="doctor">
                                            <c:forEach var="x" items="${listD}">
                                                <option value="${x.id}" ${x.id == m.doctor.id ? "selected" : ""}>${x.fullname}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label class="control-label">Status</label>
                                        <select class="form-control" id="exampleSelect2" name="status">
                                            <c:forEach var="x" items="${listS}">
                                                <option value="${x.id}" ${x.id == m.status.id ? "selected" : ""}>${x.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <tr>

                                    <button class="btn btn-save" type="submit">Update</button>
                                    <a class="btn btn-cancel" href="index.html">Hủy bỏ</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>


        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>
        <script>
            function deleteRow(r) {
                var i = r.parentNode.parentNode.rowIndex;
                document.getElementById("myTable").deleteRow(i);
            }
            jQuery(function () {
                jQuery(".trash").click(function () {
                    swal({
                        title: "Cảnh báo",

                        text: "Bạn có chắc chắn là muốn xóa nhân viên này?",
                        buttons: ["Hủy bỏ", "Đồng ý"],
                    })
                            .then((willDelete) => {
                                if (willDelete) {
                                    swal("Đã xóa thành công.!", {

                                    });
                                }
                            });
                });
            });
            oTable = $('#sampleTable').dataTable();
            $('#all').click(function (e) {
                $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
                e.stopImmediatePropagation();
            });

            //Thời Gian
            function time() {
                var today = new Date();
                var weekday = new Array(7);
                weekday[0] = "Chủ Nhật";
                weekday[1] = "Thứ Hai";
                weekday[2] = "Thứ Ba";
                weekday[3] = "Thứ Tư";
                weekday[4] = "Thứ Năm";
                weekday[5] = "Thứ Sáu";
                weekday[6] = "Thứ Bảy";
                var day = weekday[today.getDay()];
                var dd = today.getDate();
                var mm = today.getMonth() + 1;
                var yyyy = today.getFullYear();
                var h = today.getHours();
                var m = today.getMinutes();
                var s = today.getSeconds();
                m = checkTime(m);
                s = checkTime(s);
                nowTime = h + " giờ " + m + " phút " + s + " giây";
                if (dd < 10) {
                    dd = '0' + dd
                }
                if (mm < 10) {
                    mm = '0' + mm
                }
                today = day + ', ' + dd + '/' + mm + '/' + yyyy;
                tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                        '</span>';
                document.getElementById("clock").innerHTML = tmp;
                clocktime = setTimeout("time()", "1000", "Javascript");

                function checkTime(i) {
                    if (i < 10) {
                        i = "0" + i;
                    }
                    return i;
                }
            }
            //In dữ liệu
            var myApp = new function () {
                this.printTable = function () {
                    var tab = document.getElementById('sampleTable');
                    var win = window.open('', '', 'height=700,width=700');
                    win.document.write(tab.outerHTML);
                    win.document.close();
                    win.print();
                }
            }


            //Modal
            $("#show-emp").on("click", function () {
                $("#ModalUP").modal({backdrop: false, keyboard: false})
            });
        </script>
        <script>
            function showMess(id) {
                var op = confirm('Bạn chắc chắn muốn xóa?');
                if (op === true) {
                    window.location.href = 'deleteemployee?id=' + id;
                }
            }
        </script>
    </body>

</html>