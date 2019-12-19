package controller;

import domain.Conversation;
import domain.Message;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetConversation extends AsyncroRequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
            String senderId = request.getParameter("sender");
            String receiverId = request.getParameter("receiver");

            if(receiverId != null && !receiverId.trim().isEmpty()) {
                Person sender = this.getPersonService().getPerson(senderId);
                Person receiver = this.getPersonService().getPerson(receiverId);

                Conversation c = this.getPersonService().getConversation(sender, receiver);
                if (c == null) {
                    c = new Conversation(sender, receiver);
                    this.getPersonService().addConversation(c);
                }
                String json = "[";

                for (Message message : c.getMessages()) {
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
