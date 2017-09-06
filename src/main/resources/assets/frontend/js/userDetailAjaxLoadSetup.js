
/**
 * Setup the load of the user detail
 * */

console.log("dentro!");

setupLoadBody();

function setupLoadBody() {
    const result = document.querySelector("body");
    result.onload = function() {
        const param = getParameterByName("id");
        console.log(param);



    };
}


/**
 * To get the GET parameters in the URL
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

