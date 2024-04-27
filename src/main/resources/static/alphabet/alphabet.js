// Функция для получения значения letter из localStorage и отображения на экране
function displayLetter() {
    var letter = getLetterFromLocalStorage(); // Получение значения letter из localStorage
    var letterDisplay = document.getElementById('letterDisplay');
    letterDisplay.textContent = 'Ваш текущий уровень: ' + letter; // Обновление содержимого элемента
}

// Вызываем функцию для отображения значения letter при загрузке страницы
displayLetter();
function redirectToLetter(letter) {
    // Формируем URL для перенаправления с параметром буквы
    localStorage.setItem('selectedLetter', letter);
    // Перенаправляем пользователя на страницу с буквой
    window.location.href = "letter.html";
}




