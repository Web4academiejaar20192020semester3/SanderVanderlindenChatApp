var addFriendButton = document.getElementById('addFriendButton');
addFriendButton.onclick = addFriend;

var addfriendRequest = new XMLHttpRequest();

function addFriend () {
    var newFriendId = document.getElementById("newFriendId").value;
    // encodeURIComponent om UTF-8 te gebruiken en speciale karakters om te zetten naar code
    document.getElementById("newFriendId").value = "";
    var data = "newFriendId=" + encodeURIComponent(newFriendId);
    addfriendRequest.open("POST", "Controller?action=AddFriend", true);
    // belangrijk dat dit gezet wordt anders kan de servlet de informatie niet interpreteren!!!
    // protocol header information
    addfriendRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    addfriendRequest.send(data);
}