<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Add New SafeStop" />
    </jsp:include>
</head>
<body ng-app="safeStopApp" class="ng-cloak">
	<jsp:include page="/WEB-INF/partials/navbar.jsp" />
	
	
    
    <!-- ANGULARJS FORM FOR NEW SAFESTOP -->
    <div class="formcontainer" ng-controller="SafeStopController as ctrl">
			<div class="card card-body">
				<div class="panel panel-default">

					<div class="formcontainer">
						<form ng-submit="ctrl.submit()" name="safeStopForm"
							class="form-horizontal">
							<input type="hidden"  ng-model="ctrl.safeStop.id" />
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="name">Name</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.safeStop.name"
											id="name" class=" form-control input-sm"
											placeholder="Enter name" required
											 />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="description">Description</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.safeStop.description" id="description"
											class="form-control input-sm"
											placeholder="Enter description" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="rating">Rating</label>
									<div class="col-md-7">
										<select class="form-select" aria-label="Default select example" ng-model="ctrl.safeStop.rating" id="rating">
										  <option selected>None selected</option>
										  <option value="1">One (Worst)</option>
										  <option value="2">Two</option>
										  <option value="3">Three</option>
										  <option value="4">Four</option>
										  <option value="5">Five (Best)</option>
										</select>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="form-actions floatRight">
									<input type="submit"
										value="{{ctrl.safeStop.id ? 'Update' : 'Add'}}"
										class="btn btn-primary btn-sm">
									<button type="button" ng-click="ctrl.reset()"
										class="btn btn-warning btn-sm"
										ng-disabled="safeStopForm.$pristine">Reset</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	
	<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
