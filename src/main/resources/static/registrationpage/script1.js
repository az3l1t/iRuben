document.getElementById("registration-form").addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent default form submission
        var formData = new FormData(this); // Create FormData object from form
        var xhr = new XMLHttpRequest(); // Create new XMLHttpRequest object

        xhr.open("POST", "/api/v1/consumer/register"); // Specify POST request to your server endpoint
        xhr.setRequestHeader("Content-Type", "application/json"); // Set Content-Type header
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    console.log("Registration successful");
                    // Optionally, redirect user to another page after successful registration
                    window.location.href = "success.html";
                } else {
                    console.error("Registration failed");
                    // Optionally, display an error message to the user
                    alert("Registration failed. Please try again.");
                }
            }
        };
        // Convert FormData object to JSON string and send it in the request body
        xhr.send(JSON.stringify(Object.fromEntries(formData.entries())));
    });