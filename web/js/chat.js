/*$(document).ready(function(){
    $('.toggleChatButton').click(function(){
        $('.chatWindow').toggle();
    });
});*/

/*$(document).ready(function() {
    $("#chatWindowName").click(function(){
        alert("Conversation started with ");
    });;
});*/


$('.friendName td:first-child').live('click', 'friendName', function() {
    startConversation($(this).text());
});

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
    document.getElementById("chatWindowNameSmall").innerText = receiverName;*/
}
