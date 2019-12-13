//WORDT NIET GEBRUIKT!
/*var webSocket;
var comments;

/*var testbutton = document.getElementById('submitButtonId1');
testbutton.addEventListener('click', function(){
    postComment(1);
});* /

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/echo");

    /*webSocket.onopen = function(event){
        writeResponse("Connection opened")
    };*  /

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };

    /*webSocket.onclose = function(event){
        writeResponse("Connection closed");
    };* /
}

function send(topicNumber){
    //comments = document.getElementById("blogTopic" + topicNumber);
    var name = document.getElementById("loggedInUser").value;
    var comment = document.getElementById("commentInputId" + topicNumber).value;
    var rating = document.getElementById("ratingInputId" + topicNumber).value;
    var text = topicNumber + name + ": " + comment + ", " + rating;
    //webSocket.send(text);
}

function closeSocket(){
    webSocket.close();
}

function  testtest() {
    document.getElementById('loggedInUser').value = "testerdetest";
}

function writeResponse(text){
    var topicNumber = text[0];
    text = text.substring(1);
    comments = document.getElementById("commentTd" + topicNumber);
    //$('#commentTr' + topicNumber).show();
    comments.innerHTML += text + "<br/>";
}

function postComment (/*topicNumber* /) {
    openSocket();
    send(1);
    closeSocket();
}
*/