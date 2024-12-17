<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body id="homepage">
<jsp:include page="navigation.jsp" />
<h1>What kind of pet are you looking for ${userName}?</h1>

<div class="homepageFormDiv">
    <form action="searchPets" method="post">
        <div class="allAnimalTypesDiv">
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="dogImg" src="images/dog_1.png" alt="A dog.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="dogCheckbox" name="dogCheckbox" value="Dog">
                    <label for="dogCheckbox">Dog</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="catImg" src="images/cat_1.png" alt="A cat.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="catCheckbox" name="catCheckbox" value="Cat">
                    <label for="catCheckbox">Cat</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="turtleImg" src="images/turtle_1.png" alt="A turtle.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="turtleCheckbox" name="turtleCheckbox" value="Turtle">
                    <label for="turtleCheckbox">Turtle</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="birdImg" src="images/bird_1.png" alt="A bird.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="birdCheckbox" name="birdCheckbox" value="Bird">
                    <label for="birdCheckbox">Bird</label>
                </div>
            </div>
        </div>
        <hr>
        <div class="allAnimalAgesDiv">
            <label for="ageInputs">Max Age</label>
            <div id="ageInputs">
                <input type="number" min="0" max="100" id="maxAnimalAge" name="maxAnimalAge" placeholder="max" required>
            </div>
        </div>
        <hr>
        <div class="allAnimalWeightsDiv">
            <label for="weightInputs">Max Weight (lbs.)</label>
            <div id="weightInputs">
                <input type="number" min="0" max="300" id="maxAnimalWeight" name="maxAnimalWeight" placeholder="max" required>
            </div>
        </div>
        <hr>
        <div class="allAnimalColorsDiv">
            <label for="colorInputs_2">Color</label>
            <div id="colorInputs_2">
                <input type="text" id="petColor" name="petColor" placeholder="color" required>
            </div>
        </div>
        <hr>
        <div class="submitButtonDiv">
            <input type="submit" name="searchForPetsButton" value="Submit">
        </div>
    </form>
</div>

</body>
<script src="homepageScript.js"></script>
</html>

