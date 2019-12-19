package controller;

import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class RegisterConfirm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<String>();
        Person person = new Person();

        setLastName(person, request, errors);
        setFirstName(person, request, errors);
        setEmail(person, request, errors);
        setGender(person, request, errors);
        setPassword(person, request, errors);
        setAge(person, request, errors);
        person.setRole(Role.LID);
        person.setStatusOffline();
        person.createEmptyFriendlist();;


        if (errors.size() < 1){
            try {
                this.getPersonService().addPerson(person);
                return "index.jsp";
            }catch(Exception e){
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
                return "register.jsp";
            }
        }else {
            request.setAttribute("errors", errors);
            return "register.jsp";
        }
    }

    private void setLastName(Person person, HttpServletRequest request, List<String> errors){
        String lastName = request.getParameter("lastname");
        try{
            person.setLastName(lastName);
            request.setAttribute("previousLastname", lastName);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    private void setFirstName(Person person, HttpServletRequest request, List<String> errors){
        String firstName = request.getParameter("firstname");
        try{
            person.setFirstName(firstName);
            request.setAttribute("previousFirstname", firstName);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    private void setEmail(Person person, HttpServletRequest request, List<String> errors){
        String email = request.getParameter("email");
        try{
            person.setUserId(email);
            request.setAttribute("previousEmail", email);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    private void setGender(Person person, HttpServletRequest request, List<String> errors){
        String gender = request.getParameter("gender");
        try{
            person.setGender(gender);
            request.setAttribute("previousGender", gender);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    private void setPassword(Person person, HttpServletRequest request, List<String> errors){
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");
        if(!password.equals(passwordConfirmation)){
            errors.add("Passwords do not match");
        }
        try{
            person.setHashedPassword(password);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }
    private void setAge(Person person, HttpServletRequest request, List<String> errors){
        try{
            int age = Integer.parseInt(request.getParameter("age"));
            person.setAge(age);
            request.setAttribute("previousAge", age);
        }catch(java.lang.NumberFormatException e){
        errors.add("Age field cannot be empty");
        }catch(Exception e) {
            errors.add(e.getMessage());
        }
    }


}
