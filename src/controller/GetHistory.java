package controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetHistory extends AsyncronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ArrayList<String> history = getPersonService().getHistory();
        String historyJSON = this.toJSON("history", history);
        //System.out.println(historyJSON);
        response.setContentType("application/json");
        return historyJSON;
    }

    private String toJSON(String key, ArrayList<String> history) {
        StringBuffer json = new StringBuffer();
        json.append("{ \"");
        json.append(key);
        if(history.size() > 0){
            json.append("\" : [");
            for(String s : history){
                json.append("{\"log\":\""+ s + "\"},");
            }
            json.deleteCharAt(json.length()-1);

            json.append("] }");
        }else{
            json.append("\" : \"\"}");
        }

        return json.toString();
    }
}
