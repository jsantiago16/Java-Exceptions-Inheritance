import java.lang.Character;

public class PersonEmployee extends Person {
    private String fname;
    private String lname;

    // Constructor with the first and last name
    public PersonEmployee(String fname, String lname){
        super(""); 
        this.setName(fname, lname);
        super.setName(lname + ", " + fname);
    }

    // Constructor with first and last names and age
    public PersonEmployee(String fname, String lname, int age){
        this(fname, lname);
        super.setAge(age);
    }

    // This method returns true if the string has no integers, false if it does 
    private boolean checkString(String s){
        // Check if the name is all letters 
        char [] nameCharArray = s.toCharArray(); // Convert name to character array

        // Go trough each character and see if it is a letter 
        for (char c : nameCharArray){
            if (!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }

    // Mehtod verifies if either first or last name has number
    public void setName(String fname, String lname) throws InvalidNameException {
        if (!checkString(fname) || !checkString(lname)){
            throw new InvalidNameException();
        }

        this.fname = fname;
        this.lname = lname;

    }
    //overridden methods inherited from Object
    public String toString(){
        return this.lname + ", " + this.fname;
    }

}