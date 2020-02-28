package domain;

import java.util.ArrayList;

public class Conversation {

    private Person person1, person2;
    private ArrayList<Message> messages = new ArrayList<>();

    public Conversation(Person person1, Person person2){
        this.setPerson1(person1);
        this.setPerson2(person2);
    }

    private void setPerson1(Person person1) {
        if(person1 == null){
            throw new DomainException("person1 is null");
        }
        this.person1 = person1;
    }

    public Person getPerson1(){
        return this.person1;
    }

    private void setPerson2(Person person2){
        if(person2 == null){
            throw new DomainException("person2 is null");
        }
        this.person2 = person2;
    }

    public Person getPerson2(){
        return this.person2;
    }

    public void addMessage(Message m){
        if (m == null){
            throw new DomainException("message is null");
        }
        this.messages.add(m);
        //sla log op in arraylist
    }

    public ArrayList<Message> getMessages(){
        return this.messages;
    }

    public boolean equals(Conversation c){
        if(this.getPerson1().equals(c.getPerson1()) && this.getPerson2().equals(c.getPerson2()) ||
                this.getPerson1().equals(c.getPerson2()) && this.getPerson2().equals(c.getPerson1())){
            return true;
        }
        return false;
    }

    public boolean equals(Person person1, Person person2){
        if(this.getPerson1().equals(person1) && this.getPerson2().equals(person2) ||
                this.getPerson1().equals(person2) && this.getPerson2().equals(person1)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String output = ("Conversation between " + person1 + " and " + person2 + ":");
        for (Message message : messages){
            output += "\n\t" + message.toString();
        }
        return output;
    }

}
