var getBlogTopicsRequest = new XMLHttpRequest();
getBlogTopics();

function getBlogTopics(){
    getBlogTopicsRequest.open("GET","Controller?action=GetBlogTopics",true);
    getBlogTopicsRequest.onreadystatechange=getBlogTopicsData;
    getBlogTopicsRequest.send(null);
}

function getBlogTopicsData () {
    if (getBlogTopicsRequest.status == 200) {
        if (getBlogTopicsRequest.readyState == 4) {

            var responseText = JSON.parse(getBlogTopicsRequest.responseText);
            var blogTopics = responseText.blogTopics;

            var blogtopicsDiv = document.getElementById("blogtopics");

            //Remove old blogtopicList, then create a new one.
            if (blogtopicsDiv.hasChildNodes()) {
                blogtopicsDiv.removeChild(blogtopicsDiv.childNodes[0]);
            }

            //create table
            var table = document.createElement("table");

            //create table head row
            var tableHeadRow = document.createElement("tr");

            //create column headings and add them to the head row
            var tableHeadAuthor = document.createElement("th");
            var tableHeadAuthorText = document.createTextNode('Author');
            tableHeadAuthor.appendChild(tableHeadAuthorText);
            tableHeadRow.appendChild(tableHeadAuthor);

            var tableHeadTopic = document.createElement("th");
            var tableHeadTopicText = document.createTextNode('Topic');
            tableHeadTopic.appendChild(tableHeadTopicText);
            tableHeadRow.appendChild(tableHeadTopic);

            var tableHeadComment = document.createElement("th");
            var tableHeadCommentText = document.createTextNode('Comment');
            tableHeadComment.appendChild(tableHeadCommentText);
            tableHeadRow.appendChild(tableHeadComment);

            var tableHeadRating = document.createElement("th");
            var tableHeadRatingText = document.createTextNode('Rating');
            tableHeadRating.appendChild(tableHeadRatingText);
            tableHeadRow.appendChild(tableHeadRating);

            //add table head row to the table
            table.appendChild(tableHeadRow);

            //create table rows
            for (var i = 0; i < blogTopics.length; i++) {
                //create  head row
                var tableRow = document.createElement('tr');
                tableRow.id = ("blogTopic" + i)

                //create cell data and add it to the row
                var author = document.createElement('td');
                var authorText = document.createTextNode(blogTopics[i].author);
                author.appendChild(authorText);
                tableRow.appendChild(author);

                var topic = document.createElement('td');
                var topicText = document.createTextNode(blogTopics[i].topic);
                topic.appendChild(topicText);
                tableRow.appendChild(topic);

                var comment = document.createElement('td');
                var commentInput = document.createElement("input");
                commentInput.type = "text";
                commentInput.id = ("commentInputId"  + i);
                commentInput.placeholder = "Comment";
                comment.appendChild(commentInput);
                tableRow.appendChild(comment);

                var rating = document.createElement('td');
                var ratingInput = document.createElement("select");
                ratingInput.id = ("ratingInputId"  + i);
                for (var j = 1; j < 11; j++) {
                    var ratingScore = document.createElement("option")
                    ratingScore.value = j;
                    var ratingScoreText = document.createTextNode(j);
                    ratingScore.appendChild(ratingScoreText);
                    ratingInput.appendChild(ratingScore);
                }
                rating.appendChild(ratingInput);
                tableRow.appendChild(rating);

                /*var submit = document.createElement('td');
                var submitButton = document.createElement('button');
                var submitButtonText = document.createTextNode("Submit!");
                submitButton.id = ("submitButtonId"  + i);
                submitButton.onclick = "send(" + i + ");";
                submitButton.appendChild(submitButtonText);
                submit.appendChild(submitButton);
                tableRow.appendChild(submit);*/

                var submit = document.createElement('td');
                var submitButton = document.createElement('input');
                submitButton.type = "button";
                submitButton.id = ("submitButtonId"  + i);
                submitButton.value = "Submit!";
                //submitButton.onclick = postComment;

                //var myVariable = 'var' + i.toString();
                //window[myVariable] = i;

                window['var'+i] = i;

                /*switch(i) {
                    case 0:
                        submitButton.addEventListener('click', function() {
                            send(var0);
                        });
                        break;
                    case 1:
                        submitButton.addEventListener('click', function() {
                            send(var1);
                        });
                        break;
                    case 2:
                        submitButton.addEventListener('click', function() {
                            send(var2);
                        });
                        break;
                    case 3:
                        submitButton.addEventListener('click', function() {
                            send(var3);
                        });
                        break;
                    case 4:
                        submitButton.addEventListener('click', function() {
                            send(var4);
                        });
                        break;
                    case 5:
                        submitButton.addEventListener('click', function() {
                            send(var5);
                        });
                        break;
                    default:
                    // code block
                }*/

                for (var k = 0; k < i; k++) {

                }

                switch(i) {
                    case 0:
                        submitButton.addEventListener('click', function() {
                            send(var0);
                        });
                        break;
                    case 1:
                        submitButton.addEventListener('click', function() {
                            send(var1);
                        });
                        break;
                    case 2:
                        submitButton.addEventListener('click', function() {
                            send(var2);
                        });
                        break;
                    case 3:
                        submitButton.addEventListener('click', function() {
                            send(var3);
                        });
                        break;
                    case 4:
                        submitButton.addEventListener('click', function() {
                            send(var4);
                        });
                        break;
                    case 5:
                        submitButton.addEventListener('click', function() {
                            send(var5);
                        });
                        break;
                    case 6:
                        submitButton.addEventListener('click', function() {
                            send(var6);
                        });
                        break;
                    case 7:
                        submitButton.addEventListener('click', function() {
                            send(var7);
                        });
                        break;
                    case 8:
                        submitButton.addEventListener('click', function() {
                            send(var8);
                        });
                        break;
                    case 9:
                        submitButton.addEventListener('click', function() {
                            send(var9);
                        });
                        break;
                    default:
                    // code block
                }

                /*submitButton.addEventListener('click', function() {
                    send(var1);
                });*/

                /*var testbutton = document.getElementById('submitButtonId1');
testbutton.addEventListener('click', function(){
    postComment(1);
});*/
                submit.appendChild(submitButton);
                tableRow.appendChild(submit);

                //add table row to the table
                table.appendChild(tableRow);

                //comments, hidden tot er comments zijn
                tableRow = document.createElement('tr');
                tableRow.id = ("commentTr" + i);
                //tableRow.style = "display:none;";

                var td = document.createElement('td');
                tableRow.appendChild(td);

                td = document.createElement('td');
                var commentDiv = document.createElement('div');
                var commentDivText = document.createTextNode("Comments: ");
                commentDiv.appendChild(commentDivText)
                commentDiv.id = ("commentTd" + i);
                td.appendChild(commentDiv);

                tableRow.appendChild(td);

                table.appendChild(tableRow);
            }

            //add table to the div
            blogtopicsDiv.appendChild(table);
        }
    }
}



//////////////////////////////////////////////////



var webSocket;
var comments;

/*var testbutton = document.getElementById('submitButtonId1');
testbutton.addEventListener('click', function(){
    postComment(1);
});*/

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/echo");

    /*webSocket.onopen = function(event){
        writeResponse("Connection opened")
    };*/

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };

    /*webSocket.onclose = function(event){
        writeResponse("Connection closed");
    };*/
}

function send(topicNumber){
    //comments = document.getElementById("blogTopic" + topicNumber);
    var nameUntrimmed = document.getElementById("loggedInUser").textContent;
    var name = nameUntrimmed.substring(3, nameUntrimmed.length - 1);
    var comment = document.getElementById("commentInputId" + topicNumber).value;
    var rating = document.getElementById("ratingInputId" + topicNumber).value;
    //var text = topicNumber + name + ": " + comment + ", " + rating;
    //webSocket.send(text);
    var text = topicNumber + "Name: " + name + "  |  Comment: " + comment + "  |  Rating: " + rating;
    webSocket.send(text);
}

function closeSocket(){
    webSocket.close();
}

/*function  testtest() {
    document.getElementById('loggedInUser').value = "testerdetest";
}*/

function writeResponse(text){
    //if (text.charAt(0) != '1' ){
    if (!isDigit(text.charAt(0))){
        //
    }
    else{
        var topicNumber = text[0];
        text = text.substring(1);
        //comments = document.getElementById("commentTd" + topicNumber);
        comments = document.getElementById("commentTd" + topicNumber);
        //$('#commentTr' + topicNumber).show();
        comments.innerHTML += "<br/>" + text;
    }
}

function postComment() {
    send("1");
}

function isDigit(char) {
    return (char === '1' || char === '2' || char === '3' || char === '4' || char === '5' || char === '6' || char === '7' || char === '8' || char === '9' || char === '0')
}
