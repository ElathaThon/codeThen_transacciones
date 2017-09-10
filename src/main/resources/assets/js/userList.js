

const ENTER_KEY_CODE = 13;
const rootPath = "/dw/api";


/**
 * setup all elements that we need
 * */
setupSearchUserButton();
setupSearchFormApi();


/**
 * Setup the button in userList to perform the search of the user that is introduced in the input value
 * */
function setupSearchUserButton() {

    const div = $(".user.search");
    const button = div.find("button");

    button.click(function () {
        const input = div.find("input").val();
        console.log("Search for: " + input);

        window.open(location.href = '/users?search=' + input, "_self");

    });

}


/**
 * Setup the SearchFrom of the API
 * */
function setupSearchFormApi() {
    const form = document.querySelector("form.search-box");
    form.onsubmit = function(event) {
        event.preventDefault(); // by default, the page is refreshed when the form is submitted
        performSearchApi();
    };
}

/**
 * Setup the button in userList to show the list of all the users
 * */
function setupFindAllUserButton() {
    const div = $(".user.search");
    const button = div.find("button");

    button.click(function () {
        const getUrl = window.location;
        const baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
        button.html('Find all');
        window.open(baseUrl, "_self");
    });
}

/**
 * Search the user with the API, it result a JSON
 * */
function performSearchApi() {
    const input = document.querySelector(".search-box input");
    const searchTerm = input.value;
    location.href = rootPath + '/users?search=' + searchTerm;
}

/**
 * To open the selected row in a new window with the user selected
 * IF I DELATE THE SRC IN USERLIST.HBS TO setupUserSearchBox.js THIS FUNCTION APPEARS TO BE UNDEFINED u.U
 * */
function detailWithAjax(id) {
    window.open('assets/frontend/userDetailAjax.html?id='+id, '_self');
}
