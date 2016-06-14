package register;

/**
 * register.Person register.
 */
public class ArrayRegister implements Register {
    /** register.Person array. */
    private Person[] persons;
    
    /** Number of persons in this register. */
    private int count;
    
    /**
     * Constructor creates an empty register with maximum size specified.
     * @param size maximum size of the register
     */
    public ArrayRegister(int size) {
        persons = new Person[size];
        count = 0;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getCount()
	 */
    @Override
	public int getCount() {
        return count;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getSize()
	 */
    @Override
	public int getSize() {
        return persons.length;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#getPerson(int)
	 */
    @Override
	public Person getPerson(int index) {
        return persons[index];
    }

    /* (non-Javadoc)
	 * @see register.Register#presentPerson(register.Person)
	 */
    @Override
	public boolean presentPerson(Person person) {
    	boolean present = false;
    	for (int i = 0; i < count; i++) {
			if(persons[i].getName().equals(person.getName()) || persons[i].getPhoneNumber().equals(person.getPhoneNumber())) {
				present = true;
			}
		}
    	return present;
    }
    
    /* (non-Javadoc)
	 * @see register.Register#addPerson(register.Person)
	 */
    @Override
	public void addPerson(Person person) {
    	if(!presentPerson(person)) {
	    	persons[count] = person;
	        count++;
	        sort();
    	}
    	else {
    		System.out.println("Person " + person + " is already present in the register");
    	}
    }
    
    
    /* (non-Javadoc)
	 * @see register.Register#findPersonByName(java.lang.String)
	 */
    @Override
	public Person findPersonByName(String name) {
    	Person person = null;
    	for (int i = 0; i < count; i++) {
			if(persons[i].getName().equals(name)) {
				person = persons[i];
				System.out.println((i+1) + ". " + person);
			}
		}
    	if(person == null) {
    		System.out.println("Person is not present in the register");
    	}
    	return person;
    }
    
    
    /* (non-Javadoc)
	 * @see register.Register#findPersonByPhoneNumber(java.lang.String)
	 */
    @Override
	public Person findPersonByPhoneNumber(String phoneNumber) {
    	Person person = null;
    	for (int i = 0; i < count; i++) {
			if(persons[i].getPhoneNumber().equals(phoneNumber)) {
				person = persons[i];
				System.out.println((i+1) + ". " + person);
			}
		}
    	if(person == null) {
    		System.out.println("Person is not present in the register");
    	}
    	return person;
        
    }
    
    @Override
	public void removePerson(Person person) {
    	int i = 0;
    	boolean found = false;
    	while (!found) {
    		if (persons[i].equals(person)) {
    			for (int j = i; j < persons.length - 1; j++) {
    				persons[j] = persons[j+1];
    			}
    			found = true;
    			count--;
    		}
    		i++;
    	}
    }

    @Override
	public void sort() {
		Person pomocna;
		for (int i = 0; i < count - 1; i++) {
			for (int j = i+1; j < count; j++) {
				if(persons[i].getName().compareTo(persons[j].getName()) > 1) {
					pomocna = persons[i];
					persons[i] = persons[j];
					persons[j] = pomocna;
				}
			}
		}
	}

    @Override
	public boolean presentPersonUpdate(Person test, int index) {
		boolean present = false;
    	for (int i = 0; i < index; i++) {
			if(persons[i].getName().equals(test.getName()) || persons[i].getPhoneNumber().equals(test.getPhoneNumber())) {
				present = true;
			}
		}
    	for (int i = index + 1; i < count; i++) {
			if(persons[i].getName().equals(test.getName()) || persons[i].getPhoneNumber().equals(test.getPhoneNumber())) {
				present = true;
			}
		}
    	return present;
	}
	
}
