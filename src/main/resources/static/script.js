function redirectToLogin() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/login", true);
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
function redirectToRegistration() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/registerPage", true);
    xhr.send();
}
