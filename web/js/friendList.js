var getFriendsRequest = new XMLHttpRequest();
getFriends();
setInterval("getFriends()", 5000);

function getFriends(){
    getFriendsRequest.open("GET","Controller?action=GetFriends",true);
    getFriendsRequest.onreadystatechange=getFriendsData;
    getFriendsRequest.send(null);
}

function getFriendsData () {
    if (getFriendsRequest.status == 200) {
        if (getFriendsRequest.readyState == 4) {

            var responseText = JSON.parse(getFriendsRequest.responseText);
            var friends = responseText.friends;

            var friendsDiv = document.getElementById("friends");

            //Remove old friendList, then create a new one.
            if (friendsDiv.hasChildNodes()) {
                friendsDiv.removeChild(friendsDiv.childNodes[0]);
            }

            var table = document.createElement("table");

            var tableHeadRow = document.createElement("tr");

            var tableHeadName = document.createElement("th");
            var tableHeadNameText = document.createTextNode('Name');
            tableHeadName.appendChild(tableHeadNameText);
            tableHeadRow.appendChild(tableHeadName);

            var tableHeadStatus = document.createElement("th");
            var tableHeadStatusText = document.createTextNode('Status');
            tableHeadStatus.appendChild(tableHeadStatusText);
            tableHeadRow.appendChild(tableHeadStatus);

            table.appendChild(tableHeadRow);

            friendsDiv.appendChild(table);

            for (var i = 0; i < friends.length; i++) {
                var tableRow = document.createElement('tr');

                var name = document.createElement('td');
                var nameText = document.createTextNode(friends[i].name);
                name.appendChild(nameText);
                tableRow.appendChild(name);

                var status = document.createElement('td');
                var statusText = document.createTextNode(friends[i].status);
                status.appendChild(statusText);
                tableRow.appendChild(status);

                table.appendChild(tableRow);

                friendsDiv.appendChild(table);
            }
        }
    }
}
