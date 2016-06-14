package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new ArrayRegister(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("Janko", "0900126"));
        register.addPerson(new Person("Hrasko", "00123456"));
        register.addPerson(new Person("Jan", "090012345"));
        register.addPerson(new Person("Jarko Brasko", "090012456"));
        
        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
    }
}