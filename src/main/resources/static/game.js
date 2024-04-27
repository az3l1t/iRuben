function fetchRandomWord() {
    fetch('/api/v1/game/random-word')
        .then(response => response.json())
        .then(data => {
            displayWord(data);
        })
        .catch(error => console.error('Ошибка:', error));
}

function displayWord(wordData) {
    const wordDisplay = document.getElementById('word');
    wordDisplay.textContent = wordData.word;

    // Сохраняем перевод слова в атрибуте data-translation
    wordDisplay.setAttribute('data-translation', wordData.translation);
}

function checkGuess() {
    const guessInput = document.getElementById('guessInput');
    const userGuess = guessInput.value.trim().toLowerCase();
    if (userGuess === '') {
        alert('Введите перевод слова!');
        return;
    }

    const translation = document.getElementById('word').getAttribute('data-translation').trim().toLowerCase();
    if (userGuess === translation) {
        document.getElementById('resultMessage').textContent = 'Правильно!';
        fetchRandomWord();
    } else {
        document.getElementById('resultMessage').textContent = 'Неправильно. Попробуйте еще раз.';
    }

    guessInput.value = '';
}

fetchRandomWord();
