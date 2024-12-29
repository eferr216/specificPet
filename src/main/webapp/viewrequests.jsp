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
            <c:set var="petRequest" value="${petRequest}" scope="request" />
            <jsp:include page="petinfo.jsp" />
            <div class="additionalDetailsLinkDiv"><a href="searchPets?link=viewAdditionalDetails&petRequestId=${petRequest.id}&user=${param.user}">View Additional Details</a></div>
        </div>
    </c:forEach>
</div>

</body>
</html>

