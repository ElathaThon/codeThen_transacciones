/**
 * setup all elements that we need
 * */
setupSearchUserButton();


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