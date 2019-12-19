var addFriendButton = document.getElementById('addFriendButton');
addFriendButton.onclick = addFriend;

var addfriendRequest = new XMLHttpRequest();

function addFriend () {
    var newFriendId = document.getElementById("newFriendId").value;
    document.getElementById("newFriendId").value = "";
    var data = "newFriendId=" + encodeURIComponent(newFriendId);
    addfriendRequest.open("POST", "Controller?action=AddFriend", true);
    addfriendRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    addfriendRequest.send(data);
}