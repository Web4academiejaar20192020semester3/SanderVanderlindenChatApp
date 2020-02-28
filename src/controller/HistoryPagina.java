package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistoryPagina extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        String destination = "historypagina.jsp";

        return destination;
    }

}
