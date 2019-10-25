package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetStatus extends AsyncroRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession();
        Person p = (Person) session.getAttribute("user");
        String statusJSON = this.toJSON("status",p.getStatus());
        response.setContentType("application/json");
        return statusJSON;
    }

    private String toJSON(String key, String value) {
        StringBuffer json = new StringBuffer();
        json.append("{ \"");
        json.append(key);
        json.append("\" : \"");
        json.append(value);
        json.append("\" }");
        return json.toString();
    }
}
