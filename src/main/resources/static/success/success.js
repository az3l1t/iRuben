function fetchUserDataAndDisplay() {
    fetch("/api/v1/consumer/getUserData/{userId}") // Замените {userId} на актуальный идентификатор пользователя
    .then(response => response.json())
    .then(data => {
        displayUserData(data);
    })
    .catch(error => console.error('Error:', error));
}

function redirectToAlphabet() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/alphabetPage", true);
        xhr.send();
}

function redirectToGame() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/gamePage", true);
        xhr.send();
}

function redirectToHistory() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/historyPage", true);
        xhr.send();
}

document.addEventListener('DOMContentLoaded', () => {
        document.querySelectorAll('.marquee-content').forEach((ul, index) => {
            let li = Array.from(ul.children);
            let totalDelay = 0;
            li.forEach((child, i) => {
                ul.append(child.cloneNode(true));
                child.style.animationDelay = `${totalDelay}s`;
                totalDelay += parseFloat(window.getComputedStyle(child).animationDuration);
            });
        });
    });
