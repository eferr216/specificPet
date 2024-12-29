<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<body id="viewresultspage">
<jsp:include page="navigation.jsp" />

<div class="allRequestsDiv">
    <c:if test="${empty petRequests}">
        <h1>There are 0 results matching your search.</h1>
    </c:if>
    <c:if test="${not empty petRequests}">
        <h1>Here are your search results:</h1>
        <c:forEach items="${petRequests}" var="petRequest">
            <div class="requestDiv">
                <c:if test="${not empty userName && not empty currentUserId && currentUserId == petRequest.user.id}">
                    <div class="editAndDeleteSection">
                        <form action="searchPets?selectedPetId=${petRequest.id}" method="post">
                            <input type="submit" name="deleteRequest" value="Delete" class="deleteSubmitButton">
                            <input type="submit" name="editRequest" value="Edit">
                        </form>
                    </div>
                </c:if>
                <c:set var="petRequest" value="${petRequest}" scope="request" />
                <jsp:include page="petinfo.jsp" />
                <c:if test="${not empty userName && not empty currentUserId && currentUserId == petRequest.user.id}">
                    <div class="additionalDetailsLinkDiv"><a href="searchPets?link=viewAdditionalDetails&petRequestId=${petRequest.id}">View Additional Details</a></div>
                </c:if>
            </div>
        </c:forEach>
    </c:if>
</div>

</body>
</html>

