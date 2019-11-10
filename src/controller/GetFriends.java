package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetFriends extends AsyncronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        ArrayList<Person> friends = person.getFriends();
        String friendsJSON = this.toJSON("friends", friends);
        response.setContentType("application/json");
        return friendsJSON;
    }

    private String toJSON(String key, ArrayList<Person> friends) {
        StringBuffer json = new StringBuffer();
        json.append("{ \"");
        json.append(key);
        if(friends.size() > 0){
            json.append("\" : [");
            for(Person p : friends){
                json.append("{\"name\":\""+ p.getFirstName() + "\",\"status\":\"" + p.getStatus() + "\",\"id\":\""+p.getUserId()+ "\"},");
            }
            json.deleteCharAt(json.length()-1);

            json.append("] }");
        }else{
            json.append("\" : \"\"}");
        }

        return json.toString();
    }
}
