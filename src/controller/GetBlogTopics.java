package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.BlogTopic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetBlogTopics extends AsyncronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HttpSession session = request.getSession();
        ArrayList<BlogTopic> blogTopics = getPersonService().getBlogTopics();

        String blogTopicsJSON = this.toJSON("blogTopics", blogTopics);
        response.setContentType("application/json");
        return blogTopicsJSON;
    }

    private String toJSON(String key, ArrayList<BlogTopic> blogTopics) {
        StringBuffer json = new StringBuffer();
        json.append("{ \"");
        json.append(key);
        if(blogTopics.size() > 0){
            json.append("\" : [");
            for(BlogTopic blogTopic : blogTopics){
                json.append("{\"author\":\"" + blogTopic.getAuthor().getFirstName() + "\",\"topic\":\""+ blogTopic.getText() + "\"},");
            }
            json.deleteCharAt(json.length()-1);

            json.append("] }");
        }else{
            json.append("\" : \"\"}");
        }

        return json.toString();
    }
}
