<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
    <meta content="text/html;charset=UTF-8"/>
    <title sec:authentication="name"></title>
    <link rel="stylesheet" th:href="@{css/bootstrap.min.css}" />
    <style type="text/css">
        body {
            padding-top: 50px;
        }
        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring Security演示</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a th:href="@{/}"> 首页 </a></li>
                <li><a th:href="@{/admin}"> admin </a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<div class="container">

    <div class="starter-template">
        <h1 th:text="${msg.title}"></h1>

        <p class="bg-primary" th:text="${msg.content}"></p>

        <div sec:authorize="hasRole('ROLE_HOME')"> <!-- 用户类型为ROLE_ADMIN 显示 -->
            <p class="bg-info" th:text="${msg.etraInfo}"></p>
        </div>
        <div sec:authorize="hasRole('ROLE_ADMIN')"> <!-- 用户类型为ROLE_ADMIN 显示 -->
            <p class="bg-info">恭喜您,您有 ROLE_ADMIN 权限 </p>
        </div>

        <form th:action="@{/logout}" method="post">
            <input type="submit" class="btn btn-primary" value="注销"/>
        </form>
    </div>

</div>


</body>
</html>