var getHistoryRequest = new XMLHttpRequest();
getHistory();
setInterval("getHistory()", 5000);

function getHistory(){
    getHistoryRequest.open("GET","Controller?action=GetHistory",true);
    getHistoryRequest.onreadystatechange=getHistoryData;
    getHistoryRequest.send(null);
}

function getHistoryData () {
    if (getHistoryRequest.status == 200) {
        if (getHistoryRequest.readyState == 4) {

            var responseText = JSON.parse(getHistoryRequest.responseText);
            var history = responseText.history;

            var historyDiv = document.getElementById("history");

            //Remove old friendList, then create a new one.
            if (historyDiv.hasChildNodes()) {
                historyDiv.removeChild(historyDiv.childNodes[0]);
            }

            var table = document.createElement("table");

            var tableHeadRow = document.createElement("tr");

            var tableHeadName = document.createElement("th");
            var tableHeadNameText = document.createTextNode('Log');
            tableHeadName.appendChild(tableHeadNameText);
            tableHeadRow.appendChild(tableHeadName);

            table.appendChild(tableHeadRow);

            historyDiv.appendChild(table);

            for (var i = 0; i < history.length; i++) {
                var tableRow = document.createElement('tr');
                var name = document.createElement('td');
                var nameText = document.createTextNode(history[i].log);
                name.appendChild(nameText);
                tableRow.appendChild(name);

                table.appendChild(tableRow);

                historyDiv.appendChild(table);
            }
        }
    }
}