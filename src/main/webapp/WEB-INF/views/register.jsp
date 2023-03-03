<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <head>
   <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head> 

  <body ng-app="safeStopApp" class="ng-cloak">
  <jsp:include page="/WEB-INF/partials/navbar.jsp" />
      <div class="container" ng-controller="AuthorizationController as ctrl">
          <div class="panel panel-default">
              <h1 class="panel-heading">User Registration Form</h1>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="userForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      
                             
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.user.email" id="email" class="email form-control input-sm" placeholder="Enter your email" required/>
                                  <div class="has-error" ng-show="userForm.$dirty">
                                  	<span class="text-danger" ng-show="userForm.email.$error.required">This field is required</span>
                                  	<span class="text-danger" ng-show="userForm.email.$invalid">Invalid email</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="username">Username</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.username" id="username" class="username form-control input-sm" placeholder="Enter your username" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="userForm.$dirty">
                                  	<span class="text-danger" ng-show="userForm.username.$error.required">This field is required</span>
                                  	<span class="text-danger" ng-show="userForm.$error.username.minlength">Username must be 3 characters long</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="password">Password</label>
                              <div class="col-md-7">
                                  <input type="password" ng-model="ctrl.user.password" id="password" class="password form-control input-sm" placeholder="Enter your password" ng-minlength="6" required/>
                                  <div class="has-error" ng-show="userForm.$dirty">
                                  	<span class="text-danger" ng-show="userForm.password.$error.required">This field is required</span>
                                  	<span class="text-danger" ng-show="userForm.password.$error.minlength">Password must be 6 characters long</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                    
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit" class="btn btn-primary btn-block mt-1" value="Sign up">
                          </div>
                      </div>
                  </form>
              </div>
          </div>
      	<jsp:include page="/WEB-INF/partials/footer.jsp"/>
	    <script src="/resources/static/js/authorizationController.js"></script>
	    <script src="/resources/static/js/authorizationService.js"></script>
  </body>
</html>