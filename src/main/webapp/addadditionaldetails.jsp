<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body id="addadditionaldetailspage">
<jsp:include page="navigation.jsp" />
<h1>Add additional details</h1>
<div class="homepageFormDiv">
    <form action="searchPets?selectedPetId=${selectedPet.id}" method="post">
        <label for="additionalDetailsTextInput">Details Text:</label>
        <input id="additionalDetailsTextInput" name="additionalDetailsText" type="text">
        <!--<input type="submit" name="insertAdditionalDetailsSubmitButton" value="Submit">-->
        <div class="submitButtonDiv">
            <input type="submit" name="insertAdditionalDetailsButton" value="Submit">
        </div>
    </form>
</div>

</body>
</html>

