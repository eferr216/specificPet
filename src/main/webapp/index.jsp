<html>
<head>
    <title>Specific Pet</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="#">Bookmarks</a></li>
    </ul>
</nav>
<h1>Specific Pet</h1>
<h2>What kind of pet are you looking for?</h2>
<form action="searchForPets" method="get">
    <div class="allAnimalTypesDiv">
        <div class="animalPictureAndCheckboxDiv">
            <div class="animalPictureDiv">
                <img src="images/specific_pet_dog_outline.png" alt="A dog.">
            </div>
            <div class="animalCheckboxDiv">
                <input type="checkbox" id="dogCheckbox" name="dogCheckbox" value="dog">
                <label for="dogCheckbox">Dog</label>
            </div>
        </div>
        <div class="animalPictureAndCheckboxDiv">
            <div class="animalPictureDiv">
                <img src="images/specific_pet_cat_outline.png" alt="A cat.">
            </div>
            <div class="animalCheckboxDiv">
                <input type="checkbox" id="catCheckbox" name="catCheckbox" value="cat">
                <label for="catCheckbox">Cat</label>
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
</body>
</html>
