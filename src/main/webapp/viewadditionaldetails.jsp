<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="css/styles.css">
</head>
<body id="viewadditionaldetailsspage">
<jsp:include page="navigation.jsp" />
<h1>Additional Details</h1>
<div class="allRequestsDiv">
    <c:forEach items="${additionalDetailsSet}" var="additionalDetails">
        <p>Additional Detail: ${additionalDetails.detailsText}</p>
    </c:forEach>
</div>
</body>
</html>

