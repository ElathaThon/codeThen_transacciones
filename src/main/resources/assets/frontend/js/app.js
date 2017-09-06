
let usersPromise = loadUsers();

usersPromise.then(users => {
	displayUsers(users);
});

// Equivalent to the code above
// loadBooks().then(displayBooks);


/** Gets books from API and returns a promise of books */
function loadUsers() {

	let url = '/api/users';

	// We return the promise that fetch() gives us
	return fetch(url)
		.then(response => response.json())
		.catch(error => {
			console.log("AJAX request finished with an error :(");
			console.error(error);
		});
}

/** Displays books on the HTML */
function displayUsers(users) {

	let html = "<ul>";

	for (const user of users) {
		html += "<li>" + user.name + "</li>";
	}

	html += "</ul>";

	const resultDiv = document.getElementById("result");
	resultDiv.innerHTML = html;
}

// We're not using this function.
// It's ok to do it this way,
// although the way we use above is a bit more elegant.

/** Gets books from API and displays them */
function loadUsersAndDisplayThem() {

	let url = '/api/users';

	fetch(url)
		.then(response => response.json())
		.then(books => {
			console.log("AJAX request finished correctly :)");
			const result = `Found ${books.length}`;
			console.log(result);
			displayBooks(books);
		})
		.catch(error => {
			console.log("AJAX request finished with an error :(");
			console.error("ERROR:", error);
		});
}
