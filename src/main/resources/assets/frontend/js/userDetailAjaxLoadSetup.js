
/**
 * Setup the load of the user detail
 * */


setupLoadBody();

function setupLoadBody() {
    const body = document.querySelector("body");
    body.onload = function() {

        const idParam = new URLSearchParams(window.location.search).get("id");
        console.log(idParam);

        loadUsers(idParam);

    };
}


/**
 * To get the GET parameters in the URL (old javaScript version)
 * To use it: const param = getParameterByName("ParamName");
 * https://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
 * */
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

