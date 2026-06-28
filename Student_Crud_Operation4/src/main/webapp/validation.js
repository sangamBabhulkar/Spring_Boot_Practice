function validateForm() {

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;

    if (name === "") {
        alert("Name required");
        return false;
    }

    if (email === "") {
        alert("Email required");
        return false;
    }

    if (phone.length !== 10) {
        alert("Phone must be 10 digits");
        return false;
    }

    return true;
}

// AJAX EMAIL CHECK
function checkEmail() {

    let email = document.getElementById("email").value;

    let xhr = new XMLHttpRequest();

    xhr.open("GET", "checkEmail?email=" + email, true);

    xhr.onload = function () {
        document.getElementById("msg").innerHTML = this.responseText;
    };

    xhr.send();
}