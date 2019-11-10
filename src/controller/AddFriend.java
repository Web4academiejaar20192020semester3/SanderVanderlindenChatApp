package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddFriend extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("newFriendId");
        HttpSession session = request.getSession();
        Person user = (Person) session.getAttribute("user");
        user.addFriend(getPersonService().getPerson(id));
        return "";
    }
}
