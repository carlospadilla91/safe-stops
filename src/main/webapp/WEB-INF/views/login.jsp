<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body ng-app="safeStopApp" class="ng-cloak">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container mt-2" ng-controller="AuthorizationController as ctrl">
        <h1>Please Log In</h1>
        <form ng-submit="ctrl.loginSubmit()">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" ng-model="username" placeholder="Enter username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" ng-model="password" placeholder="Enter password" required>
            </div>
            <input type="submit" class="btn btn-primary btn-block mt-1" value="Log In">
            <div class="text-danger">{{errorMessage}}</div>
        </form>
    </div>
    
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
    <script src="/resources/static/js/authorizationController.js"></script>
    <script src="/resources/static/js/authorizationService.js"></script>
</body>
</html>