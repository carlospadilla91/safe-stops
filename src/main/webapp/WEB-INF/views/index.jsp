<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<style>
	.title {
	font-family: "Garamond", cursive }
</style>
<body>
   <jsp:include page="/WEB-INF/partials/navbar.jsp" />
	
    <main class="container-fluid">
    	<div class="p-5 mb-4 bg-light rounded-3">
    		<div class="container-fluid py-5">
    			<h1 class="title p-4 mb-3 bg-success text-light rounded-2">SafeStops</h1>
    			<p class="col-md-8 fs-5 text-success">Hit the road safely!</p>
    		</div>
    	</div>
    </main>
    
    <jsp:include page="/WEB-INF/partials/footer.jsp"/>
</body>
</html>