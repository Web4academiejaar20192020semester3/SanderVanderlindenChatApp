$(document).ready(function(){
    getMessages();

    $('#toggleChatButton').click(function(){
        $('#chatWindow').toggle();

        if($("#chatWindow").is(":visible")){
            $('#toggleChatButton').text("Hide chat");
            $('#toggleChatButton').css("background-color", "#F0F0F0");
            $('#toggleChatButton').css("color", "#666666");
            $('.right').css("background-color", "#FFCC00");

        } else{
            $('#toggleChatButton').text("Show chat");
            $('#toggleChatButton').css("background-color", "#FFCC00");
            $('#toggleChatButton').css("color", "#000000");
            $('.right').css("background-color", "#EEEEEE");

        }
    });

    $('.friendName').live('click', 'friendName', function() {
    startConversation($(this).children('td:nth-child(1)').text(), $(this).children('td:nth-child(3)').text());
    });

    function startConversation(name, id){
        $('#chatWindowName').text("Chat with " + name +":");
        $('#receiver').val(id);
        $('#' + name).css("background-color", "#FFCC00");
        setTimeout(function () {
            $('#' + name).css("background-color", "#F0F0F0");
        }, 250);
    }

    $("#chatWindowSendButton").click(function send(){
        /*var message = $("#chatWindowInput").val();
        $("#chatWindowInput").val("");
        $("#chatWindowContent").text(message);
        getMessages();*/
        var message = $("#chatWindowInput").val();
        $("#chatWindowInput").val("");

        $.ajax({
            type: "POST",
            url: "Controller?action=SendMessage",
            data: {
                "senderId": $('#sender').val(),
                "receiverId":  $('#receiver').val(),
                "message": message
            },
            dataType: "json",
            success: function() {
                $("#chatWindowName").css("background-color", "#7cff00");
                getMessages();
            },
            error: function(){
                $("#chatWindowName").css("background-color", "#1e1e1e");
                getMessages();
            }
        });
    });

    function getMessages(){
        var sender = $('#sender').val();
        var receiver = $('#receiver').val();

        $.get("Controller?action=GetConversation&senderId=" + sender + "&receiverId=" + receiver, function(data){
            var contentContainer = $("#chatWindowContent");
            contentContainer.empty();

            $.each(data, function(i, message){
                var p = $("<p></p>").text(message.message);

                if(message.sender == sender){
                    $(p).addClass("senderMessage");
                }else{
                    $(p).addClass("receiverMessage");
                }

                contentContainer.append(p);
            });
            setTimeout(getMessages, 2000);
        })
    }

});
