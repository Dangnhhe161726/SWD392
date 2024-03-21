<%-- 
    Document   : Dashboard
    Created on : Mar 19, 2024, 8:47:02 PM
    Author     : FPT SHOP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Navbar-->

        <header class="app-header">     
            <ul class="app-nav">
                <li>
                    <a class="app-sidebar__user" href="home"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                        <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146ZM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5Z"/>
                        </svg></a>
                </li>
                <li><a class="app-nav__item" href="Logout"><i class='bx bx-log-out bx-rotate-180'></i></a>
                </li>
            </ul>
        </header>

        <!-- Sidebar menu-->

        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <div>
                    <p class="app-sidebar__user-name"><b>${sessionScope.first_name} ${sessionScope.first_name}</b></p>
                    <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
                </div>
            </div>
        </div>
        <hr>
        <ul class="app-menu">
            <!--Admin dashboard-->
            <c:if test="${sessionScope.role == 4}">
                <li><a class="app-menu__item " href="AdminHome"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">User List</span></a></li>
                <li><a class="app-menu__item" href="loadem"><i class='app-menu__icon bx bx-task'></i>
                        <span class="app-menu__label">Employee List</span></a></li>
            </c:if>
            <c:if test="${sessionScope.role == 2 || sessionScope.role == 4}">
                <li><a class="app-menu__item" href="listpatient"><i class='app-menu__icon bx bx-task'></i>
                        <span class="app-menu__label">Patient List</span></a></li>
                <li><a class="app-menu__item" href="medicalhistory"><i class='app-menu__icon bx bx-task'></i>
                        <span class="app-menu__label">Medical History</span></a></li>
            </c:if>
        </ul>
    </aside>
</body>
</html>

