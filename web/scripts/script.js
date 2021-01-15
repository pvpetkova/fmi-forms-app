// let xhttp;
//
// function init() {
//     xhttp = new XMLHttpRequest();
// }
//
// // just a sample method
// function getAllUsers() {
//     const url = "http://localhost:8080/users/all";
//     xhttp.open('GET', url, true);
//     xhttp.send(null);
//     xhttp.onreadystatechange = function () {
//
//         const empname = document.getElementById("empname");
//         console.log(xhttp.readyState)
//         console.log(xhttp.status)
//
//         if (xhttp.status === 200) {
//             if (xhttp.readyState === 4) {
//                 const det = eval("(" + xhttp.responseText + ")");
//                 console.log(det)
//                 empname.value = det[0].username;
//             }
//         } else
//             console.log("Error: " + xhttp.responseText);
//     };
// }

function getSearchParameters() {
    const paramString = window.location.search.substr(1);
    return paramString != null && paramString !== "" ? transformToAssocArray(paramString) : {};
}

function transformToAssocArray(prmstr) {
    let params = {};
    let paramsArray = prmstr.split("&");
    for (let i = 0; i < paramsArray.length; i++) {
        const tempArray = paramsArray[i].split("=");
        params[tempArray[0]] = tempArray[1];
    }
    return params;
}

function checkIsLoggedIn() {
    if (!sessionStorage.getItem('user')) {
        window.location.replace("login_page.html");
    }
}

function logout() {
    // remove current user
    sessionStorage.removeItem('user');
    window.location.replace("login_page.html");
}