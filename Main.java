import java.util.Scanner;
import java.util.InputMismatchException;

class Main {

  // Method to print an array of objects 
  public static void printList(Object[] objectArray){
      for (int i = 0; i < objectArray.length; i++){
          System.out.println(i+1 + ": " + objectArray[i].toString());
      }
  }


  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    String firstName, lastName;
    int numberOfPeople = 0, age;
    PersonEmployee personEmployeeArray[];
    boolean nextIteration = false;


    // Get the number of people for the database
    while(!nextIteration){

        try{
        System.out.println("\nEnter the number of people to add to the database: ");
        numberOfPeople = scan.nextInt();
        nextIteration = true; // Get out of the loop
        }
        catch(InputMismatchException e){
            scan.nextLine();  // Consume the newline
            System.out.println("The number of people was not an integer. Please try again.");
        }

    }
    

    // Initialize the array
    personEmployeeArray = new PersonEmployee[numberOfPeople];

    for (int i = 0; i < numberOfPeople; i++){

        System.out.println("\nEntry #" + (i+1));

        nextIteration = false;

        while(!nextIteration){

            try{
                scan.nextLine();  // Consume the newline

                // Get the first name
                System.out.println("\nEnter first name: ");
                firstName = scan.nextLine();

                // Get the last name 
                System.out.println("Enter last name: ");
                lastName = scan.nextLine();

                // Create the particular instance of the object 
                personEmployeeArray[i] = new PersonEmployee(firstName, lastName);

                // Get the age 
                System.out.println("Enter age: ");
                age = scan.nextInt();        
                
                // Set the age with the setter from the superclass 
                personEmployeeArray[i].setAge(age);

                nextIteration = true; // Get out of the loop
            }

            catch(InvalidNameException e){
                System.out.println(e.getMessage());
                System.out.println("Press <enter> to try again.");

            }

            catch (InputMismatchException e){
                System.out.println("Age input was not an integer. Please try again.");
            }

        }
    }

    System.out.println("\nDo you wish to display the database entries? (y/n): ");
    String answer = scan.next();

    if (answer.equalsIgnoreCase("y")){
        System.out.println("\nDatabase Entries");
        printList(personEmployeeArray);
    }
  }

}