
/**
 * Setup the search box in the user list to can make a search using AJAX
 * */


const ENTER_KEY_CODE = 13;

setupSearchFormVanilla();


// With <form>
//
// These functions expect the submit event on the <form>

function setupSearchFormVanilla() {
    const form = document.querySelector("form.search-box");
    form.onsubmit = function(event) {
        event.preventDefault(); // by default, the page is refreshed when the form is submitted
        performSearchVanilla();
    };
}

// Common

function performSearchVanilla() {
    const input = document.querySelector(".search-box input");
    const searchTerm = input.value;
    location.href = 'api/users?search=' + searchTerm;
}

/**
 * To open the selected row in a new window with the user selected
 * */
function openInNewTabWithAjax(id) {
    console.log("selected user with id: " + id);

    window.open('assets/frontend/userDetailAjax.html?id='+id, '_blank').focus();

}
