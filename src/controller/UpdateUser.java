package controller;

        import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUser extends AsyncronousRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        Person person = this.getPersonService().getPerson(id);
        person.setAge(age);
        person.setGender(gender);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        this.getPersonService().updatePersons(person);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "";
    }
}
