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
    <a href="makerequest.jsp"><span class="material-symbols-outlined">add_circle</span></a><span>-    Add new pet request</span>
</div>

<div class="allRequestsDiv">
    <c:forEach items="${petRequests}" var="petRequest">
        <div class="requestDiv">
            <div class="editAndDeleteSection">
                <div><a href="deleteRequest.jsp?requestId=${petRequest.id}"><span class="material-symbols-outlined">delete</span></a></div>
                <div><a href="editRequest.jsp?requestId=${petRequest.id}"><span class="material-symbols-outlined">edit</span></a></div>
            </div>
            <div class="aboutSectionContainer">
                <div class="aboutPetImageSection">
                    <c:if test="${petRequest.petSpecies == 'Dog'}">
                        <img src="images/dog_2.png" alt="Dog">
                    </c:if>
                    <c:if test="${petRequest.petSpecies == 'Cat'}">
                        <img src="images/cat_2.png" alt="Cat">
                    </c:if>
                    <c:if test="${petRequest.petSpecies == 'Turtle'}">
                        <img src="images/turtle_2.png" alt="Turtle">
                    </c:if>
                    <c:if test="${petRequest.petSpecies == 'Bird'}">
                        <img src="images/bird_2.png" alt="Bird">
                    </c:if>
                </div>
                <div class="aboutPetSection">
                    <ul>
                        <li><span>Type: </span>${petRequest.petSpecies}</li>
                        <li><span>Age: </span>${petRequest.petAge}</li>
                        <li><span>Weight: </span>${petRequest.petWeight} lbs.</li>
                        <li><span>Color: </span>${petRequest.petColor}</li>
                    </ul>
                </div>
            </div>
            <div class="additionalDetailsLinkDiv"><a href="searchPets?link=viewAdditionalDetails&petRequestId=${petRequest.id}">View Additional Details</a></div>
        </div>
    </c:forEach>
</div>

</body>
</html>

