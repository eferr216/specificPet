<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="css/styles.css">
</head>
<body id="viewrequestspage">
<jsp:include page="navigation.jsp" />
<h1>Get notified when a pet with specific traits becomes available.</h1>
<h2>My Pet Requests</h2>
<div class="addNewPetRequestDiv">
    <a href="requests.jsp"><span class="material-symbols-outlined">add_circle</span></a><span>-    Add new pet request</span>
</div>

<div class="allRequestsDiv">
    <c:forEach items="${petRequests}" var="petRequest">
        <div class="requestDiv">
            <div class="editAndDeleteSection">
                <div><a href="#"><span class="material-symbols-outlined">delete</span></a></div>
                <div><a href="#"><span class="material-symbols-outlined">edit</span></a></div>
            </div>
            <div class="aboutPetSection">
                <ul>
                    <li><span>Type: </span>${petRequest.petSpecies}</li>
                    <li><span>Age: </span>${petRequest.petAge}</li>
                    <li><span>Weight: </span>${petRequest.petWeight}</li>
                    <li><span>Color: </span>${petRequest.petColor}</li>
                </ul>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>

