package domain;

import java.util.ArrayList;

public class Conversation {

    private Person person0, person1;
    private ArrayList<Message> messages = new ArrayList<>();

    public Conversation(Person p0, Person p1){
        this.setPerson0(p0);
        this.setPerson1(p1);
    }

    public Conversation(){}

    public void setPerson0(Person p0) {
        if(p0 == null){
            throw new DomainException("person0 is invalid");
        }
        this.person0 = p0;
    }

    public Person getPerson0(){
        return this.person0;
    }

    public void setPerson1(Person p1){
        if(p1 == null){
            throw new DomainException("person1 is invalid");
        }
        this.person1 = p1;
    }

    public Person getPerson1(){
        return this.person1;
    }

    public void addMessage(Message m){
        if (m == null){
            throw new DomainException("invalid message");
        }
        this.messages.add(m);
    }

    public ArrayList<Message> getMessages(){
        return this.messages;
    }

    public boolean checkConversation(Person p0, Person p1){
        if ((p0.getUserId().equals(this.person0.getUserId())&&p1.getUserId().equals(this.person1.getUserId())) || (p0.getUserId().equals(this.person1.getUserId())&&p1.getUserId().equals(this.person0.getUserId()))) {
            return true;
        }
        else{return false;}
    }

    public boolean equals(Conversation c){
        if((this.getPerson0().equals(c.getPerson0()) && this.getPerson1().equals(c.getPerson1())) || (this.getPerson0().equals(c.getPerson1()) && this.getPerson1().equals(c.getPerson0()))){
            return true;
        }
        return false;
    }

}
