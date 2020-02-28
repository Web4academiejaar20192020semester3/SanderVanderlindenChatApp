package controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddChatLog extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        String senderId = request.getParameter("senderId");
        String receiverId = request.getParameter("receiverId");

        if (!(senderId.trim().isEmpty() || receiverId.trim().isEmpty())){
            this.getPersonService().addChatLog("Sender: " + senderId + " | Receiver: " + receiverId); //TIJD EN DATUM TOEVOEGEN, MOEILIJK ZONDER INTERNET
        }

        return "";
    }
}
