<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<body id="deleteadditionaldetailspage">
<jsp:include page="navigation.jsp" />
<h1>Delete Confirmation</h1>
<main>
    <h2 style="margin-top: 50px; margin-bottom: 20px;">Are you sure you want to delete this item?</h2>
    <c:if test="${petRequest.petSpecies == 'Dog'}">
        <img src="images/dog_2.png" alt="Dog">
    </c:if>
    <form action="searchPets?selectedPetId=${requestId}" method="post">
        <input type="submit" id="deleteAdditionalDetails" name="confirmDeleteDetails" value="Delete">
        <input type="submit" id="cancelDeleteAdditionalDetails" name="cancelDeleteDetails" value="Cancel">
    </form>
</main>
</body>
</html>
