package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Users extends AsyncronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        String result = "[";
        List<Person> users = this.getPersonService().getPersons();
        if(users.size() > 0){
            for(Person p : users){
                result += "{\"lastName\":\"" + p.getLastName() + "\",\"firstName\":\"" + p.getFirstName() + "\",\"email\":\"" + p.getUserId() + "\",\"gender\":\"" + p.getGender() + "\",\"age\":" + p.getAge() + "},";
            }
            result = result.substring(0, result.length()-1);
        }
        result += "]";
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");
        return result;
    }
}
