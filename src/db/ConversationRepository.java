package db;

import domain.Conversation;
import domain.Message;
import domain.Person;

import java.util.List;

public interface ConversationRepository {

    public abstract void add(Conversation conversation);

    public abstract Conversation get(Person p0, Person p1);

    public abstract List<Conversation> getAll();

    public abstract void addMessage(Message m, Person p0, Person p1);

    public abstract void updateConversation(Conversation c);

}
