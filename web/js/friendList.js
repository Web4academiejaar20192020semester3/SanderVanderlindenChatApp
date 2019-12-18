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
                //tableRow.setAttribute("id", friends[i].id);
                tableRow.setAttribute("id", friends[i].name);
                tableRow.setAttribute("class", "friendName");
                /*tableRow.addEventListener("click", function(){
                    startConversation(friends[i].name)
                });*/
                /*$(id).click(function(){
                    startConversation(id)
                });*/

                var name = document.createElement('td');
                var nameText = document.createTextNode(friends[i].name);
                name.appendChild(nameText);
                /*name.addEventListener("click", function(){
                    startConversation(friends[i].name)
                });*/
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

/*
$('.friendName td:first-child').live('click', 'friendName', function() {
    startConversation($(this).text());
    //alert( $(this).text());
});

//function startConversation(){
function startConversation(name){
    $('#' + name).css("background-color", "#FFCC00");
    /*$('#chat').show();
    $('#chatWindowNameSmall').hide();
    $('#chatWindow').show();
    var receiverId = this.id;
    var receiver = document.getElementById("receiver");
    var tr = document.getElementById(receiverId);
    var receiverName = tr.childNodes[0].textContent;
    receiver.setAttribute("value", receiverId.toString());
    document.getElementById("chatWindowName").innerText = receiverName;
    document.getElementById("chatWindowNameSmall").innerText = receiverName;*//*
}
*/