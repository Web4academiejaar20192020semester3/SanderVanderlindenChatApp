var webSocket;
var messages;

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/echo");

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };
}

function send(id){
    messages = document.getElementById("messages" + id);
    var name = document.getElementById("messageinputName" + id).value;
    var comment = document.getElementById("messageinputComment" +id).value;
    var rating = document.getElementById("messageinputRating" + id).value;
    var text = id + name + ": " + comment + ", " + rating;
    webSocket.send(text);
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text){
    var id = text[0];
    text = text.substring(1);
    var totalId = "messages" + id;
    messages = document.getElementById(totalId);
    $('#' + totalId).show();
    messages.innerHTML += text + "<br/>";
}