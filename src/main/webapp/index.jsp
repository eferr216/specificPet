<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body id="homepage">
<nav>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <c:choose>
            <c:when test="${empty userName}">
                <li><a href="logIn">Log In</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="#">My Requests</a></li>
                <li><a href="#">Bookmarks</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
<h1>What kind of pet are you looking for?</h1>

<div class="homepageFormDiv">
    <form action="searchForPets" method="get">
        <div class="allAnimalTypesDiv">
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="dogImg" src="images/dog_1.png" alt="A dog.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="dogCheckbox" name="dogCheckbox" value="dog">
                    <label for="dogCheckbox">Dog</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="catImg" src="images/cat_1.png" alt="A cat.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="catCheckbox" name="catCheckbox" value="cat">
                    <label for="catCheckbox">Cat</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="turtleImg" src="images/turtle_1.png" alt="A turtle.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="turtleCheckbox" name="turtleCheckbox" value="turtle">
                    <label for="turtleCheckbox">Turtle</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="birdImg" src="images/bird_1.png" alt="A bird.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="birdCheckbox" name="birdCheckbox" value="bird">
                    <label for="birdCheckbox">Bird</label>
                </div>
            </div>
        </div>
        <hr>
        <div class="allAnimalAgesDiv">
            <label for="ageInputs">Age</label>
            <div id="ageInputs">
                <input type="number" min="0" max="100" id="minAnimalAge" name="minAnimalAge" placeholder="min">
                -
                <input type="number" min="0" max="100" id="maxAnimalAge" name="maxAnimalAge" placeholder="max">
            </div>
        </div>
        <hr>
        <div class="allAnimalWeightsDiv">
            <label for="weightInputs">Weight</label>
            <div id="weightInputs">
                <input type="number" min="0" max="100" id="minAnimalWeight" name="minAnimalAge" placeholder="min">
                -
                <input type="number" min="0" max="300" id="maxAnimalWeight" name="maxAnimalAge" placeholder="max">
            </div>
        </div>
        <hr>
        <div class="submitButtonDiv">
            <input type="submit" name="submitButton" value="Submit">
        </div>
    </form>
</div>

</body>
<script src="homepageScript.js"></script>
</html>

