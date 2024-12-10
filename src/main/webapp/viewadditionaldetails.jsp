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
    <div class="allRequestsDiv">
            <div class="requestDivClone">
                <div class="aboutSectionContainer">
                    <div class="aboutPetImageSection">
                        <c:if test="${selectedPet.petSpecies == 'Dog'}">
                            <img src="images/dog_2.png" alt="Dog">
                        </c:if>
                        <c:if test="${selectedPet.petSpecies == 'Cat'}">
                            <img src="images/cat_2.png" alt="Cat">
                        </c:if>
                        <c:if test="${selectedPet.petSpecies == 'Turtle'}">
                            <img src="images/turtle_2.png" alt="Turtle">
                        </c:if>
                        <c:if test="${selectedPet.petSpecies == 'Bird'}">
                            <img src="images/bird_2.png" alt="Bird">
                        </c:if>
                    </div>
                    <div class="aboutPetSection">
                        <ul>
                            <li><span>Type: </span>${selectedPet.petSpecies}</li>
                            <li><span>Age: </span>${selectedPet.petAge}</li>
                            <li><span>Weight: </span>${selectedPet.petWeight} lbs.</li>
                            <li><span>Color: </span>${selectedPet.petColor}</li>
                        </ul>
                    </div>
                </div>
            </div>
    </div>
    <div class="addNewAdditionalDetailsDiv">
        <a href="searchPets?link=addNewAdditionalDetails&selectedPetId=${selectedPet.id}"><span class="material-symbols-outlined">add_circle</span></a><span>-    Add new additional details</span>
    </div>

    <c:forEach items="${additionalDetailsSet}" var="additionalDetails">
        <div class="allAdditionalDetailsDiv">
            <div class="additionalDetailsDiv">
                <p class="additionalDetailsText">Additional Detail: ${additionalDetails.detailsText}</p>
                <span class="additionalDetailsEditAndDeleteSection">
                    <!--<a href="deleteAdditionalDetails.jsp?detailsId=${additionalDetails.id}"><span class="material-symbols-outlined">delete</span></a>
                    <a href="editAdditionalDetails.jsp?detailsId="><span class="material-symbols-outlined">edit</span></a>-->
                    <form action="searchPets?selectedPetId=${selectedPet.id}&detailsId=${additionalDetails.id}" method="post">
                        <input type="submit" name="deleteDetails" value="Delete" class="deleteSubmitButton">
                        <input type="submit" name="editDetails" value="Edit">
                    </form>
                </span>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>

