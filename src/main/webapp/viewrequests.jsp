<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body id="viewrequestspage">
<jsp:include page="navigation.jsp" />
<h1>Get notified when a pet with specific traits becomes available?</h1>
<h2>My Pet Requests</h2>
<div class="allRequestsDiv">
    <c:forEach items="${petRequests}" var="petRequest">
        <p>A request!!</p>
    </c:forEach>
</div>

</body>
</html>

