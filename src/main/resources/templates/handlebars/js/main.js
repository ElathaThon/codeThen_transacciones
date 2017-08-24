
setupSearchUserButton();

/** Setup the button in userList to perform the search of the user that is introduced in the input value */
function setupSearchUserButton() {

    const div = $(".user.search");
    const button = div.find("button");

    button.click( function() {
        const input = div.find("input").val();
        console.log("Search for: " + input);

        if (input != null) {
            const getUrl = window.location;
            const baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
            window.open(baseUrl+"?search="+input , "_self");
            //setupFindAllUserButton();
        }
    });

}

/** Setup the button in userList to show the list of all the users */
function setupFindAllUserButton() {
    const div = $(".user.search");
    const button = div.find("button");

    button.click( function() {
        const getUrl = window.location;
        const baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
        button.html('Find all');
        window.open(baseUrl , "_self");
    });
}