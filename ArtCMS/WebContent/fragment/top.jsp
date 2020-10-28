<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css" type="text/css" />

<script src="${pageContext.request.contextPath}/javascript/jquery-1.9.1.js"></script>

<c:set var='debug' value='true' scope='application' />
<nav class="navbar navbar-expand-lg navbar navbar-dark " style="background-color: #1b9aaa;">
        <a class="navbar-brand" href="<c:url value='/index.jsp' />"><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-flower2" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M8 16a4 4 0 0 0 4-4 4 4 0 0 0 0-8 4 4 0 0 0-8 0 4 4 0 1 0 0 8 4 4 0 0 0 4 4zm3-12a3 3 0 0 0-6 0c0 .073.01.155.03.247.544.241 1.091.638 1.598 1.084A2.987 2.987 0 0 1 8 5c.494 0 .96.12 1.372.331.507-.446 1.054-.843 1.598-1.084.02-.092.03-.174.03-.247zm-.812 6.052A2.99 2.99 0 0 0 11 8a2.99 2.99 0 0 0-.812-2.052c.215-.18.432-.346.647-.487C11.34 5.131 11.732 5 12 5a3 3 0 1 1 0 6c-.268 0-.66-.13-1.165-.461a6.833 6.833 0 0 1-.647-.487zm-3.56.617a3.001 3.001 0 0 0 2.744 0c.507.446 1.054.842 1.598 1.084.02.091.03.174.03.247a3 3 0 1 1-6 0c0-.073.01-.155.03-.247.544-.242 1.091-.638 1.598-1.084zm-.816-4.721A2.99 2.99 0 0 0 5 8c0 .794.308 1.516.812 2.052a6.83 6.83 0 0 1-.647.487C4.66 10.869 4.268 11 4 11a3 3 0 0 1 0-6c.268 0 .66.13 1.165.461.215.141.432.306.647.487zM8 9a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
          </svg>得藝的一天後台系統</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/_18_course/Home.jsp' />">藝文課程管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/_18_course/Home.jsp' />">街頭藝人管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/_03_cultural_and_creative_shops_cms/index.jsp' />">藝文商店管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/DemoServlet' />">得藝洋行商品管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/_35_cms/cmsIndex.jsp' />">租借場地管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/_35_geoSearch/RandomRecom' />">離我最近的活動</a>
                </li>
                
            </ul>
            <div>
        <ul class="navbar-nav mr-auto">
        <c:if test="${ funcName != 'REG' }">
            <a class="nav-link" href="<c:url value='/_35_register/register.jsp' />">會員註冊</a>
       </c:if>
       <c:if test="${ funcName == 'REG' }">  
            <a class="nav-link" href="<c:url value='/_35_register/register.jsp' />">會員註冊</a>
       </c:if>
       <c:if test="${empty LoginOK}">
            <a class="nav-link" href="<c:url value='/_35_login/login.jsp'/>">會員登入</a>
		</c:if>
		<c:if test="${ ! empty LoginOK }">
            <a class="nav-link" href="<c:url value='/_35_login/logout.jsp'/>">登出</a>
  		 </c:if>
  		 <c:if test="${ ! empty LoginOK }">
  		 <p class="userName">Welcome! ${LoginOK.name}</p>
				</c:if>
        </ul>
    </div>
        </div>
    </nav>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%-- <div>${pageContext.session.id }</div> --%>