<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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