
/**
 * Student class for modeling real Student.
 *
 * @author Upal Roy
 * @version 1.0.0
 */
public class Student
{
   // instance variables - number and name represent number and name of each student respectively
   private int number;
   private String name;
    
   /**
    * Changes the number of this Student
    * 
    * @param number This Student's new number 
    */
   public void setNumber(int number) {
      this.number = number;
   }
   
   /**
    * Gets the number of this Student
    * 
    * @return this Student's number
    */
   public int getNumber() {
      return number;
   }
   
   /**
    * Changes the name of this Student
    * 
    * @param name This Student's new name 
    */
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * Gets the name of this Student
    * 
    * @return this Student's name
    */
   public String getName() {
      return name;
   }
   
   /**
    * Constructor for objects of class Student
    */
   public Student(int number, String name)
   {
       // initialise instance variables - number and name
       this.number = number;
       this.name = name;
   }
}
