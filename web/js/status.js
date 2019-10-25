var getStatusRequest = new XMLHttpRequest();
var changeStatusRequest = new XMLHttpRequest();

var button = document.getElementById("statusButton");
button.onclick = changeStatus;

function changeStatus() {
    updateStatus();
    setTimeout("getStatus()", 1000);
}

function getStatus () {
    getStatusRequest.open("GET","Controller?action=GetStatus",true);
    getStatusRequest.onreadystatechange=getStatusData;
    getStatusRequest.send(null);
}

function getStatusData () {
    if(getStatusRequest.status == 200){
        if(getStatusRequest.readyState == 4){
            var responseText = JSON.parse(getStatusRequest.responseText);
            var status = responseText.status;

            var statusDiv = document.getElementById("status");
            var statusParagraph = statusDiv.childNodes[0];

            if(statusParagraph == null){
                statusParagraph = document.createElement('p');
                statusParagraph.id = "statusText";
                var statusText = document.createTextNode(status);
                statusParagraph.appendChild(statusText);
                statusDiv.appendChild(statusParagraph);
            }
            else
            {
                var statusText = document.createTextNode(status);
                statusParagraph.removeChild(statusParagraph.childNodes[0]);
                statusParagraph.appendChild(statusText);
            }
        }
    }
}

function updateStatus(){
    var statusText = document.getElementById("statusInput").value;
    document.getElementById("statusInput").value = "";
    var data = "status=" + encodeURIComponent(statusText);
    changeStatusRequest.open("POST","Controller?action=UpdateStatus",true);
    changeStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    changeStatusRequest.send(data);
}