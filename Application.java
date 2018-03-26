import java.util.*;

/**
 * Write a description of class Application here.
 *
 * @author Upal Roy
 * @version 1.0.0
 */
public class Application
{
    //instance object - to referance a LabMaster.
    static LabMaster labMaster = new LabMaster();
    //instance object - to referance a Scanner.
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]){
        while(true){
            System.out.println();
            System.out.println("1. Add a lab to the list");
            System.out.println("2. Delete a lab from the list");
            System.out.println("3. List available labs ");
            System.out.println("4. Register a student for a lab");
            System.out.println("5. Remove a student from a lab");
            System.out.println("6. Move a student from a lab to another");
            System.out.println("7. List all labs booked for a student");
            System.out.println("8. Exit");
            System.out.println("Select your choice by entering number:");
            
            int choiceNumber = sc.nextInt(); //scan choice number   

            if(choiceNumber == 1)
                addLab();
            else if(choiceNumber == 2)
                deleteLab();
            else if(choiceNumber == 3)
                listOfAvailableLabs();
            else if(choiceNumber == 4)
                registerAStudent();
            else if(choiceNumber == 5)
                removeStudent();
            else if(choiceNumber == 6)
                moveStudentsLab();
            else if(choiceNumber == 7)
                allLabsBookedForAStudent();
            else if(choiceNumber == 8)
                exit();
        }
    }
    
    /**
     * Add labs to LabMaster's list after taking input from user
     *
     */
    public static void addLab(){
        sc.nextLine();
        System.out.println("Enter subject code for the lab: ");
        String subjectCode = sc.nextLine(); // scan subject code
        System.out.println("Enter lab number: ");        
        int labNumber = sc.nextInt(); // scan lab number
        sc.nextLine();
        System.out.println("Enter room number: ");
        String roomNumber = sc.nextLine(); // scan room number
        System.out.println("Enter tutor name: ");
        String tutorName = sc.nextLine(); // scan tutor name
        System.out.println("Enter lab time: ");
        String labTime = sc.nextLine(); // scan lab time
        System.out.println("Enter lab capacity: ");
        int labCapacity = sc.nextInt(); // scan lab capacity
        
        Lab newLab = new Lab(subjectCode, labNumber, roomNumber, tutorName, labTime, labCapacity);
        labMaster.addLab(newLab);
        System.out.println("New lab successfully added.");
    }
    
    /**
     * Delete a lab from LabMaster's list after taking input from user
     *
     */
    public static void deleteLab(){
        sc.nextLine();
        System.out.println("Enter the subject code of the lab that you want to delete: ");
        String subjectCode = sc.nextLine(); // scan subject code
        System.out.println("Enter the lab number of the lab that you want to delete: ");
        int labNumber = sc.nextInt(); // scan lab number
        
        if(labMaster.removeLab(subjectCode, labNumber) == 1)
            System.out.println("The selected lab has successfully deleted");
        else if (labMaster.removeLab(subjectCode, labNumber) == 2)
            System.out.println("The selected lab has not found. Please enter information correctly.");
        else if (labMaster.removeLab(subjectCode, labNumber) == 3)
            System.out.println("The selected lab has registered students in it. So can not delete the selected lab.");
        else if(labMaster.removeLab(subjectCode, labNumber) == 0)
            System.out.println("Please enter correct information of the lab.");    
    }
    
    /**
     * Find the abailable labs from LabMaster's list after taking input from user
     *
     */
    public static void listOfAvailableLabs(){        
        ArrayList<Lab> availableLabList = labMaster.listOfAvailableLabs(); // all available labs' list
        
        if(availableLabList.size() > 0){
            System.out.println("Subject code   Lab#   Room     Time    Tutor   Capacity   Registrations");
            for(int i = 0; i < availableLabList.size(); i++) {   
                System.out.println(availableLabList.get(i).getSubjectCode() 
                + "         " + availableLabList.get(i).getLabNumber() 
                + "     " + availableLabList.get(i).getRoomNumber() 
                + "    " + availableLabList.get(i).getLabTime() 
                + "     "+ availableLabList.get(i).getTutorName() 
                + "       " + availableLabList.get(i).getLabCapacity() 
                + "           " + availableLabList.get(i).getNumberOfStudents());                                                           
            }
        }
        else
        {
            System.out.println("No lab available for registration.");
        }
    }
    
    /**
     * Register a student into a lab after taking input from user
     *
     */
    public static void registerAStudent(){
       sc.nextLine();
       System.out.println("Enter student number for registration: ");
       int studentNumber = sc.nextInt(); //scan student number
       sc.nextLine();
       System.out.println("Enter student name for registration: ");
       String studentName = sc.nextLine(); //scan student name
        
       System.out.println("Enter the subject code of the lab where student want to enroll: ");
       String subjectCode = sc.nextLine(); // scan subject code
       System.out.println("Enter the lab number of the lab where student want to enroll: ");
       int labNumber = sc.nextInt(); // scan lab number

       Lab alreadyEnrolledLab = labMaster.inWhichLabStudentRegistered(subjectCode, studentNumber);
       if(alreadyEnrolledLab != null){
           System.out.println("This student already Registered in lab number: " + alreadyEnrolledLab.getLabNumber());
       }
       else{
           Lab foundLab = labMaster.findLab(subjectCode, labNumber);
           if(foundLab != null){
               if(foundLab.getLabCapacity() > foundLab.getNumberOfStudents()){
                   foundLab.addStudent(studentNumber, studentName);
                   System.out.println("Student successfully registered in the lab");
               }
               else {
                   System.out.println("There is no seat available in this lab. All seats are booked.");
               }
           }
           else {
               System.out.println("Please provide correct information of the lab where you want to enroll.");
           }    
        }     
     }
    
    /**
     * Remove a student from specific subject's lab after taking input from user
     *
     */ 
    public static void removeStudent(){
       sc.nextLine();
       System.out.println("Enter student number to remove student from the lab: ");
       int studentNumber = sc.nextInt(); //scan student number
       sc.nextLine();
       System.out.println("Enter the subject code to remove student from that subject's lab: ");
       String subjectCode = sc.nextLine(); // scan subject code
        
       if(labMaster.removeStudentFromLab(subjectCode, studentNumber))
           System.out.println("Student successfully removed from the lab.");
       else
           System.out.println("No such student found to remove. Plese provide the information correctly.");
     }
    
    /**
     * Move student's lab for a specific subject after taking input from user
     *
     */ 
    public static void moveStudentsLab(){
        System.out.println("Enter the student number to move in another lab:");
        int studentNumber = sc.nextInt(); //scan student number
        sc.nextLine();
        System.out.println("Enter the subject code for which subject studen want to change the lab.");
        String subjectCode = sc.nextLine(); // scan subject code
        System.out.println("Enter the lab number in which student want to transfer.");
        int labNumber = sc.nextInt(); // scan lab number
        
        Lab alreadyEnrolledLab = labMaster.inWhichLabStudentRegistered(subjectCode, studentNumber);
        if(alreadyEnrolledLab != null){
            Student student = alreadyEnrolledLab.findStudent(studentNumber);         
            if(student != null){
                String studentName = student.getName();
                labMaster.removeStudentFromLab(subjectCode, studentNumber);
            
                Lab foundLab = labMaster.findLab(subjectCode, labNumber);
                if(foundLab != null){
                    foundLab.addStudent(studentNumber, studentName);
                    System.out.println("Student successfully moved in the desired lab.");
                }
                else {
                    System.out.println("Please provide correct information about the lab where you want to move.");
                }
            }
            else {
                System.out.println("No such student found to move. Please provide the information correctly.");
            }
        }        
        else {
            System.out.println("Either the subject code or the student number is not correct.");
        }   
    }  
    
    /**
     * Show all the labs that booked by a student for different subjects after taking input from user
     *
     */
    public static void allLabsBookedForAStudent(){
        sc.nextLine();
        System.out.println("Enter student number to show all the bookings: ");
        int studentNumber = sc.nextInt(); //scan student number
        
        ArrayList<Lab> bookedLabList = labMaster.allLabsBookedForAStudent(studentNumber); // all booked labs' list for a student
        
        if(bookedLabList.size() > 0){
            System.out.println("Subject code   Lab#   Room     Time    Tutor   Capacity   Registrations");
            for(int i = 0; i < bookedLabList.size(); i++) {   
                System.out.println(bookedLabList.get(i).getSubjectCode() 
                + "         " + bookedLabList.get(i).getLabNumber() 
                + "     " + bookedLabList.get(i).getRoomNumber() 
                + "    " + bookedLabList.get(i).getLabTime() 
                + "     "+ bookedLabList.get(i).getTutorName() 
                + "       " + bookedLabList.get(i).getLabCapacity() 
                + "           " + bookedLabList.get(i).getNumberOfStudents());                                                           
            }
        }
        else
        {
            System.out.println("No lab booked for this student.");
        }
    }
    
    public static void exit(){
        System.exit(0);
    }
}
