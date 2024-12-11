<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body id="makerequestpage">
<jsp:include page="navigation.jsp" />
<h1>Would you like to be notified when a pet with specific traits becomes available?</h1>
<h2>If so, fill out the form below!</h2>

<div class="homepageFormDiv">
    <form action="searchPets?userName=${userName}" method="post">
        <div class="allAnimalTypesDiv">
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="dogImg_2" src="images/dog_1.png" alt="A dog.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="dogCheckbox_2" name="dogCheckbox" value="Dog">
                    <label for="dogCheckbox_2">Dog</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="catImg_2" src="images/cat_1.png" alt="A cat.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="catCheckbox_2" name="catCheckbox" value="Cat">
                    <label for="catCheckbox_2">Cat</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="turtleImg_2" src="images/turtle_1.png" alt="A turtle.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="turtleCheckbox_2" name="turtleCheckbox" value="Turtle">
                    <label for="turtleCheckbox_2">Turtle</label>
                </div>
            </div>
            <div class="animalPictureAndCheckboxDiv">
                <div class="animalPictureDiv">
                    <img id="birdImg_2" src="images/bird_1.png" alt="A bird.">
                </div>
                <div class="animalCheckboxDiv">
                    <input type="checkbox" id="birdCheckbox_2" name="birdCheckbox" value="Bird">
                    <label for="birdCheckbox_2">Bird</label>
                </div>
            </div>
        </div>
        <hr>
        <div class="allAnimalAgesDiv">
            <label for="ageInputs_2">Max Age</label>
            <div id="ageInputs_2">
                <input type="number" min="0" max="100" id="maxAnimalAge" name="maxAnimalAge" placeholder="max" required>
            </div>
        </div>
        <hr>
        <div class="allAnimalWeightsDiv">
            <label for="weightInputs_2">Max Weight</label>
            <div id="weightInputs_2">
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
            <input type="submit" name="insertPetRequestButton" value="Submit">
        </div>
    </form>
</div>

</body>
<script src="requestsScript.js"></script>
</html>

