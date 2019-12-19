package db;

import domain.*;

import java.util.ArrayList;
import java.util.List;

public class ConversationRepositoryStub implements ConversationRepository {

    private ArrayList<Conversation> conversations = new ArrayList<>();

    public ConversationRepositoryStub(){
        Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", Role.LID);
        Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", Role.LID);
        Conversation anJanConv = new Conversation(jan, an);
        Message janToAn = new Message("Dag An, Jan hier. Hoor je mij?", jan, an);
        anJanConv.addMessage(janToAn);
        Message anToJan = new Message("Luid en duidelijk, Jan!", an, jan);
        anJanConv.addMessage(anToJan);
        add(anJanConv);
    }

    @Override
    public void add(Conversation conversation) {
        if(conversation == null){
            throw new DomainException("conversation is null");
        }
        this.conversations.add(conversation);
    }

    @Override
    public Conversation getConversation(Person person1, Person person2) {
        for(Conversation conversation : this.conversations){
            if(conversation.equals(person1, person2)){
                return conversation;
            }
        }
        Conversation conversation = new Conversation(person1, person2);
        this.conversations.add(conversation);
        return conversation;
    }

    @Override
    public List<Conversation> getAll() {
        return this.conversations;
    }

    @Override
    public void addMessage(Message message) {
        Conversation conversation = this.getConversation(message.getSender(), message.getReceiver());
        conversation.addMessage(message);
    }
}
