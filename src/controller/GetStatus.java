package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetStatus extends AsyncronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response)throws IOException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String statusJSON = this.toJSON("status",person.getStatus());

        response.setContentType("application/json");
        System.out.println(statusJSON);
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
