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
<form action="searchForPets" method="post">
    <div class="allAnimalTypesDiv">
        <div class="animalPictureAndCheckboxDiv">
            <div class="animalPictureDiv">
                <img src="images/default_dog" alt="A dog.">
            </div>
            <div class="animalCheckboxDiv">
                <input type="checkbox" id="dogCheckbox" name="dogCheckbox" value="dog">
                <label for="dogCheckbox">Dog</label>
            </div>
        </div>
        <div class="animalPictureAndCheckboxDiv">
            <div class="animalPictureDiv">
                <img src="images/default_cat" alt="A cat.">
            </div>
            <div class="animalCheckboxDiv">
                <input type="checkbox" id="catCheckbox" name="catCheckbox" value="cat">
                <label for="catCheckbox">Cat</label>
            </div>
        </div>
    </div>
    <div class="submitButtonDiv">
        <input type="submit" name="submitButton" value="Submit">
    </div>
</form>
</body>
</html>
