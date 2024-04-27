function displayHistory(history) {
    const historyInfoContainer = document.getElementById("history-info");
    historyInfoContainer.innerHTML = `
        <h2>${history.name}</h2>
        <p>${history.history}</p>
        <img src="${history.URL}" alt="Изображение истории">
    `;
    historyInfoContainer.classList.add("show"); // Добавление класса для отображения элемента с анимацией
}

document.getElementById("history1").addEventListener("click", function() {
    fetchHistory(0);
});

document.getElementById("history2").addEventListener("click", function() {
    fetchHistory(1);
});

document.getElementById("history3").addEventListener("click", function() {
    fetchHistory(2);
});

function fetchHistory(historyId) {
    fetch(`/api/v1/history/getById/${historyId}`)
    .then(response => response.json())
    .then(data => {
        displayHistory(data);
    })
    .catch(error => console.error('Error:', error));
}