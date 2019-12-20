package domain;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String userId;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	private Role role;
	private String status;
    private ArrayList<Person> friends;
    private ArrayList<BlogTopic> blogTopics;
    private String gender;
    private int age;


    public Person(String userId, String password, String firstName,
			String lastName,Role role) {
		setUserId(userId);
		setHashedPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setStatusOffline();
        createEmptyFriendlist();
        createEmptyBlogTopiclist();
	}



    public Person(String userId, String password, String salt,
			String firstName, String lastName,Role role) {
        this(userId, password, firstName, lastName, role);
		setSalt(salt);
	}

	public Person() {
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role=role;
	}


	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new IllegalArgumentException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(hashPassword(password, getSalt()));
	}

	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	public void setHashedPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(20);

		String salt = new BigInteger(1, seed).toString(16);
		this.setSalt(salt);

		return hashPassword(password, salt);
	}

	private String hashPassword(String password, String seed) {
		String hashedPassword = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(salt.getBytes("UTF-8"));
			crypt.update(password.getBytes("UTF-8"));
			hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new DomainException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new DomainException(e.getMessage(), e);
		}
		return hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public void setStatus(String s){
		if(s.trim().isEmpty()){
			throw new DomainException("Status is invalid");
		}
		this.status = s;
	}

	public String getStatus() {
		return this.status;
	}

    public void addFriend(Person friend) {
	    if (friend == null){
	        throw new DomainException("That person does not exist.");
        }
        if (friend.equals(this)){
            throw new DomainException("You can't add yourself as a friend.");
        }
        if (!friends.contains(friend)){
            this.friends.add(friend);
            friend.addAcceptFriend(this);
        }
    }

	public void addAcceptFriend(Person friend) {
		this.friends.add(friend);
	}


	public ArrayList<Person> getFriends(){
	    return this.friends;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Person)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Person person = (Person) o;

        // Compare the data members and return accordingly
        return this.userId.equals(person.userId);
    }

    public void addBlogTopic(String blogTopic) {
        if (blogTopic == null){
            throw new DomainException("That String does not exist.");
        }
        this.blogTopics.add(new BlogTopic(this, blogTopic));
    }

    public ArrayList<BlogTopic> getBlogTopics(){
        return this.blogTopics;
    }

	@Override
	public String toString() {
		return (firstName + " " + lastName + " " + userId + " " + role);
	}

    public void setGender(String gender) {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("No gender given");
        }
        this.gender = gender;
    }

    public void setAge(int age) {
        if (age < 0 || age > 125) {
            throw new IllegalArgumentException("Age must be an integer between 0 and 125");
        }
        this.age = age;
    }

    public void createEmptyFriendlist() {
        friends = new ArrayList<>();
    }

    public void createEmptyBlogTopiclist() {
        blogTopics = new ArrayList<>();
    }

    public void setStatusOffline(){
        setStatus("offline");
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }
}
