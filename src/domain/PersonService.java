package domain;

import db.ConversationRepository;
import db.ConversationRepositoryStub;
import db.PersonRepository;
import db.PersonRepositoryStub;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private PersonRepository personRepository = new PersonRepositoryStub();
    private ConversationRepository conversationRepository = new ConversationRepositoryStub();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
        if(personId == null){
            throw new IllegalArgumentException("No id given");
        }		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public ArrayList<BlogTopic> getBlogTopics(){
		ArrayList<BlogTopic> blogTopics = new ArrayList<>();
		for (Person person: getPersons()){
			for (BlogTopic blogtopic : person.getBlogTopics()){
				if (!blogTopics.contains(blogtopic)){
					blogTopics.add(blogtopic);
				}
			}
		}

		return blogTopics;
	}


	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void addMessageToConversation(Message message) {
        conversationRepository.addMessage(message);
	}

    public Conversation getConversation(Person person1, Person person2) {
	    return conversationRepository.getConversation(person1, person2);
    }
}
