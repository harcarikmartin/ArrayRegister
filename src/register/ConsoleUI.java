package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
    /** register.Register of persons. */
    private Register register;
    
    /**
     * In JDK 6 use Console class instead.
     * @see readLine()
     */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Menu options.
     */
    private enum Option {
        PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
    };
    
    public ConsoleUI(Register register) {
        this.register = register;
    }
    
    public void run() {
        while (true) {
            switch (showMenu()) {
                case PRINT:
                    printRegister();
                    break;
                case ADD:
                    addToRegister();
                    break;
                case UPDATE:
                    updateRegister();
                    break;
                case REMOVE:
                    removeFromRegister();
                    break;
                case FIND:
                    findInRegister();
                    break;
                case EXIT:
                    return;
            }
        }
    }
    
    private String readLine() {
        //In JDK 6.0 and above Console class can be used
        //return System.console().readLine();
        
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    private Option showMenu() {
        System.out.println("Menu.");
        for (Option option : Option.values()) {
            System.out.printf("%d. %s%n", option.ordinal() + 1, option);
        }
        System.out.println("-----------------------------------------------");
        
        int selection = -1;
        do {
            System.out.println("Option: ");
            selection = Integer.parseInt(readLine());
        } while (selection <= 0 || selection > Option.values().length);
        
        return Option.values()[selection - 1];
    }
    
    
    private void printRegister() {
	    	for (int i = 0; i < register.getCount(); i++) {
				System.out.println((i + 1) + ". " + register.getPerson(i).toString());
			}
    }
    
    private void addToRegister() {
        System.out.println("Enter Name: ");
        String name = readLine();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = readLine();
        
        register.addPerson(new Person(name, phoneNumber));
    }
    
    
    private void updateRegister() {
    	 System.out.println("Enter index to be updated: ");
    	 int index = Integer.parseInt(readLine());
    	 if(index <= 0 || index > register.getCount()) {
         	System.out.println("Index out of bounds!");
         	updateRegister();
         } else {
	    	 System.out.println("Updating (name/number)?: ");
	    	 String flag = readLine();
	    	 if(flag.equals("name")) {
		         System.out.println("Enter Name: ");
		         String name = readLine();
		         Person test = new Person(name, register.getPerson(index - 1).getPhoneNumber());
		         if(!register.presentPersonUpdate(test, index - 1)) {
			         register.getPerson(index - 1).setName(name);
			         register.sort();
		         }
		         else {
		        	 System.out.println("Person called " + test.getName() + " is already present in the register");
		         }
	    	 }
	    	 else if(flag.equals("number")) {
		         System.out.println("Enter Phone Number: ");
		         String phoneNumber = readLine();
		         Person test = new Person(register.getPerson(index - 1).getName(), phoneNumber);
		         if(!register.presentPersonUpdate(test, index - 1)) {
			         register.getPerson(index - 1).setPhoneNumber(phoneNumber);
			         register.sort();
		         }
		         else {
		        	 System.out.println("Person with number " + test.getPhoneNumber() + " is already present in the register");
		         }
	    	 }
	    	 else {
	    		 System.out.println("Wrong flag!");
	    	 	 updateRegister();
	    	 }
         }
    }
    
    private void findInRegister() {
    	System.out.println("Finding by (name/number): ");
   	 	String flag = readLine();
   	 	if(flag.equals("name")) {
   	 		System.out.println("Type the name to find: ");
   	 		String name = readLine();
   	 		register.findPersonByName(name);
   	 	}
   	 	else if(flag.equals("number")) {
   	 		System.out.println("Type the number to find: ");
	 		String phoneNumber = readLine();
	 		register.findPersonByPhoneNumber(phoneNumber);
   	 	}
   	 	else {
   	 		System.out.println("Wrong flag!");
   	 		findInRegister();
   	 	}
    }
    
    private void removeFromRegister() {
        System.out.println("Enter index: ");
        int index = Integer.parseInt(readLine());
        if(index <= 0 || index > register.getCount()) {
        	System.out.println("Index out of bounds!");
        	removeFromRegister();
        } else {
        	Person person = register.getPerson(index - 1);
            register.removePerson(person);
        }
        
    }

}
