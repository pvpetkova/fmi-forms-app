let xhttp;

function init() {
    xhttp = new XMLHttpRequest();
}

// just a sample method
function getAllUsers() {
    const url = "http://localhost:8080/users/all";
    xhttp.open('GET', url, true);
    xhttp.send(null);
    xhttp.onreadystatechange = function () {

        const empname = document.getElementById("empname");
        console.log(xhttp.readyState)
        console.log(xhttp.status)

        if (xhttp.status === 200) {
            if (xhttp.readyState === 4) {
                const det = eval("(" + xhttp.responseText + ")");
                console.log(det)
                empname.value = det[0].username;
            }
        } else
            console.log("Error: " + xhttp.responseText);
    };
}

function logout() {
    // TODO: implement
    console.log('Goodbye')
}