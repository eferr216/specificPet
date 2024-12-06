const dogCheckbox_2 = document.querySelector('#dogCheckbox_2');
const catCheckbox_2 = document.querySelector('#catCheckbox_2');
const turtleCheckbox_2 = document.querySelector('#turtleCheckbox_2');
const birdCheckbox_2 = document.querySelector('#birdCheckbox_2');

dogCheckbox_2.addEventListener('change', function() {
    var dogImage_2 = document.getElementById('dogImg_2');
    if (this.checked) {
        dogImage_2.src = 'images/dog_2.png';
    } else {
        dogImage_2.src = 'images/dog_1.png';
    }
})

catCheckbox_2.addEventListener('change', function() {
    var catImage_2 = document.getElementById('catImg_2');
    if (this.checked) {
        catImage_2.src = 'images/cat_2.png';
    } else {
        catImage_2.src = 'images/cat_1.png';
    }
})
turtleCheckbox_2.addEventListener('change', function() {
    var turtleImage_2 = document.getElementById('turtleImg_2');
    if (this.checked) {
        turtleImage_2.src = 'images/turtle_2.png';
    } else {
        turtleImage_2.src = 'images/turtle_1.png';
    }
})

birdCheckbox_2.addEventListener('change', function() {
    var birdImage_2 = document.getElementById('birdImg_2');
    if (this.checked) {
        birdImage_2.src = 'images/bird_2.png';
    } else {
        birdImage_2.src = 'images/bird_1.png';
    }
})