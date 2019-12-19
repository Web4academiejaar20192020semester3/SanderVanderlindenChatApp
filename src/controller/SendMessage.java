package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Message;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMessage extends AsyncroRequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        String senderId = request.getParameter("sender");
        String receiverId = request.getParameter("receiver");
        String message = request.getParameter("message");

        Person sender = this.getPersonService().getPerson(senderId);
        Person receiver = this.getPersonService().getPerson(receiverId);

        Message m = new Message(message, sender);
        this.getPersonService().addMessageToConversation(m, sender, receiver);

        return "";
    }
}
