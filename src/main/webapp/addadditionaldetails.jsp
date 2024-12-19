<jsp:include page="header.jsp" />
<body id="addadditionaldetailspage">
<jsp:include page="navigation.jsp" />
<h1>Add additional details</h1>
<div class="homepageFormDiv">
    <form action="searchPets?selectedPetId=${selectedPet.id}" method="post">
        <label for="additionalDetailsTextInput">Details Text:</label>
        <input id="additionalDetailsTextInput" name="additionalDetailsText" type="text" required>
        <div class="submitButtonDiv">
            <input type="submit" name="insertAdditionalDetailsButton" value="Submit">
        </div>
    </form>
</div>

</body>
</html>

