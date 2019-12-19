package domain;

public class Message {

    private String message;
    private Person sender, receiver;

    public Message(String message, Person sender, Person receiver){
        this.setMessage(message);
        this.setSender(sender);
        this.setReceiver(receiver);
    }

    private void setMessage(String m) {
        if(m.trim().isEmpty()){
            throw new DomainException("Empty message");
        }
        this.message = m;
    }

    public String getMessage(){
        return this.message;
    }

    private void setSender(Person sender){
        if(sender == null){
            throw new DomainException("sender is null");
        }
        this.sender = sender;
    }

    public Person getSender() {
        return sender;
    }

    private void setReceiver(Person receiver){
        if(receiver == null){
            throw new DomainException("receiver is null");
        }
        this.receiver = receiver;
    }

    public Person getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return ("from: " + sender + " | to: " + receiver + " | message: " + message);
    }
}
