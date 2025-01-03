<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <c:choose>
            <c:when test="${empty userName}">
                <li><a href="logIn">Log In</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="searchPets?link=petRequests&user=${userName}">Requests</a></li>
                <li>[User - ${userName}]</li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>