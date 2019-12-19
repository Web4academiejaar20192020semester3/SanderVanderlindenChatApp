package controller;

import domain.Conversation;
import domain.Message;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetConversation extends AsyncronousRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
            String senderId = request.getParameter("senderId");
            String receiverId = request.getParameter("receiverId");

        if (!(senderId.trim().isEmpty() || receiverId.trim().isEmpty())) {
            Person sender = this.getPersonService().getPerson(senderId);
            Person receiver = this.getPersonService().getPerson(receiverId);
            Conversation conversation = this.getPersonService().getConversation(sender, receiver);

            String json = "[";

            for (Message message : conversation.getMessages()) {
                json += "{\"sender\":\"" + message.getSender().getUserId() + "\", " +
                        "\"message\":\"" + message.getMessage() + "\"},";
            }
            json = json.replaceAll(",$", "");
            json += "]";
            response.setContentType("application/json");
            try {
                response.getWriter().write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }
}
