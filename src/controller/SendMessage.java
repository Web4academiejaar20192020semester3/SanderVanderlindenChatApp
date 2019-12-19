package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMessage extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        String senderId = request.getParameter("senderId");
        String receiverId = request.getParameter("receiverId");
        String messageString = request.getParameter("message");

        if (!(senderId.trim().isEmpty() || receiverId.trim().isEmpty() || messageString.trim().isEmpty())){
            Person sender = this.getPersonService().getPerson(senderId);
            Person receiver = this.getPersonService().getPerson(receiverId);
            Message message = new Message(messageString, sender, receiver);
            this.getPersonService().addMessageToConversation(message);
        }

        return "";
    }
}
