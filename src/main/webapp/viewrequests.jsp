<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<body id="viewrequestspage">
<jsp:include page="navigation.jsp" />
<h1>Get notified when a pet with specific traits becomes available.</h1>
<div class="addNewPetRequestDiv">
    <a href="makerequest.jsp?user=${param.user}"><span class="material-symbols-outlined">add_circle</span></a><span>-    Add new pet request</span>
</div>

<div class="allRequestsDiv">
    <c:forEach items="${petRequests}" var="petRequest">
        <div class="requestDiv">
            <div class="editAndDeleteSection">
                <form action="searchPets?selectedPetId=${petRequest.id}&user=${param.user}" method="post">
                    <input type="submit" name="deleteRequest" value="Delete" class="deleteSubmitButton">
                    <input type="submit" name="editRequest" value="Edit">
                </form>
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
            <div class="additionalDetailsLinkDiv"><a href="searchPets?link=viewAdditionalDetails&petRequestId=${petRequest.id}&user=${param.user}">View Additional Details</a></div>
        </div>
    </c:forEach>
</div>

</body>
</html>

