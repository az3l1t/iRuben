// Извлекаем параметр буквы из URL
const selectedLetter = localStorage.getItem('selectedLetter');
// Отображаем выбранную букву на странице
document.getElementById('letter').innerText = selectedLetter;