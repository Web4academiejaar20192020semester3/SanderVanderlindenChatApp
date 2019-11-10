var getBlogTopicsRequest = new XMLHttpRequest();
getBlogTopics();
setInterval("getBlogTopics()", 5000);


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

            var table = document.createElement("table");

            var tableHeadRow = document.createElement("tr");

            var tableHeadTopic = document.createElement("th");
            var tableHeadTopicText = document.createTextNode('Topic');
            tableHeadTopic.appendChild(tableHeadTopicText);
            tableHeadRow.appendChild(tableHeadTopic);

            table.appendChild(tableHeadRow);

            blogtopicsDiv.appendChild(table);

            for (var i = 0; i < blogTopics.length; i++) {
                var tableRow = document.createElement('tr');

                var topic = document.createElement('td');
                var topicText = document.createTextNode(blogTopics[i].topic);
                topic.appendChild(topicText);
                tableRow.appendChild(topic);

                table.appendChild(tableRow);

                blogtopicsDiv.appendChild(table);
            }
        }
    }
}
