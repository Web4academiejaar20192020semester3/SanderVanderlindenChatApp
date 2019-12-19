package db;

import domain.Conversation;
import domain.DomainException;
import domain.Message;
import domain.Person;
import java.util.ArrayList;
import java.util.List;

public class ConversationRepositoryStub implements ConversationRepository {

    private ArrayList<Conversation> conversations = new ArrayList<>();

    public ConversationRepositoryStub(){}

    @Override
    public void add(Conversation conversation) {
        if(conversation == null){
            throw new DomainException("invalid conversation");
        }
        this.conversations.add(conversation);
    }

    @Override
    public Conversation get(Person p0, Person p1) {
        if (this.conversations.size() < 1){
            return null;
        }
        for(Conversation c : this.conversations){
            if(c.checkConversation(p0, p1)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void updateConversation(Conversation c){
        for (Conversation con : this.conversations){
            if (con.equals(c)){
                this.conversations.remove(con);
                this.conversations.add(c);
            }
        }
    }

    @Override
    public List<Conversation> getAll() {
        return this.conversations;
    }

    @Override
    public void addMessage(Message m, Person p0, Person p1) {
        Conversation c = this.get(p0, p1);
        c.addMessage(m);
        this.updateConversation(c);
    }
}
