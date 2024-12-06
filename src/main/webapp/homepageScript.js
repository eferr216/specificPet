const dogCheckbox = document.querySelector('#dogCheckbox');
const catCheckbox = document.querySelector('#catCheckbox');
const turtleCheckbox = document.querySelector('#turtleCheckbox');
const birdCheckbox = document.querySelector('#birdCheckbox');
dogCheckbox.addEventListener('change', function() {
    var dogImage = document.getElementById('dogImg');
    if (this.checked) {
        dogImage.src = 'images/dog_2.png';
    } else {
        dogImage.src = 'images/dog_1.png';
    }
})

catCheckbox.addEventListener('change', function() {
    var catImage = document.getElementById('catImg');
    if (this.checked) {
        catImage.src = 'images/cat_2.png';
    } else {
        catImage.src = 'images/cat_1.png';
    }
})

turtleCheckbox.addEventListener('change', function() {
    var turtleImage = document.getElementById('turtleImg');
    if (this.checked) {
        turtleImage.src = 'images/turtle_2.png';
    } else {
        turtleImage.src = 'images/turtle_1.png';
    }
})

birdCheckbox.addEventListener('change', function() {
    var birdImage = document.getElementById('birdImg');
    if (this.checked) {
        birdImage.src = 'images/bird_2.png';
    } else {
        birdImage.src = 'images/bird_1.png';
    }
})