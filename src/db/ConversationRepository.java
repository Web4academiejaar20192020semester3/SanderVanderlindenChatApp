package db;

import domain.Conversation;
import domain.Message;
import domain.Person;

import java.util.List;

public interface ConversationRepository {

    void add(Conversation conversation);

    Conversation getConversation(Person person1, Person person2);

    List<Conversation> getAll();

    void addMessage(Message message);
}
