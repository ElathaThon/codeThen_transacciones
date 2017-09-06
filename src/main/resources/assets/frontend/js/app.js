

/**
 * Setup the load of body to find the id param and load the user detail with this id
 * And setup the back button to go to the list of users
 * */


setupLoadBody();
setupBackButton();

/**
 * Setup the onload to the body and load the user information
 * */
function setupLoadBody() {
    const body = document.querySelector("body");
    body.onload = function() {

        const idParam = new URLSearchParams(window.location.search).get("id");
        console.log(idParam);

        let usersPromise = loadUsers(idParam);

        usersPromise.then(users => {
            displayUsers(users);
        });

    };
}

/**
 * Setup the button back to go to the user list
 * */
function setupBackButton() {
    const backButton = document.querySelector("button.back");
    console.log(backButton);
    backButton.onclick = function () {
        window.open(location.href = '/users', "_self");
    }
}

/**
 *  Gets users from API and returns a promise of users
 *  */
function loadUsers(id) {

	let url = '/api/users/'+id;

	// We return the promise that fetch() gives us
	return fetch(url)
		.then(response => response.json())
		.catch(error => {
			console.log("AJAX request finished with an error :(");
			console.error(error);
		});
}


/**
 * Displays users on the HTML
 * */
function displayUsers(user) {

    console.log(user);

	let html = "El user with name " + user.name + ", have " + user.credit + " bitcoins.";

	const content = document.getElementById("content");
	content.innerHTML = html;
}

