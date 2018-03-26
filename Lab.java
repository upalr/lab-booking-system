import java.util.*;
/**
 * Lab class for modeling real Lab
 *
 * @author Upal Roy
 * @version 1.0.0
 */
public class Lab
{
   // instance variables - subjectCode, labNumber, roomNumber, tutorName, labTime, labCapacity and studentList represent 
   //subject code, lab number, room number, tutor name, lab time, lab capacity and student list of each lab respectively
   private String subjectCode;
   private int labNumber;
   private String roomNumber;
   private String tutorName;
   private String labTime;
   private int labCapacity;
   private ArrayList<Student> studentList;
    
   /**
    * Changes the subjectCode of this Lab
    * 
    * @param subjectCode This Lab's new subjectCode 
    */
   public void setSubjectCode(String subjectCode) {
      this.subjectCode = subjectCode;
   }
   
   /**
    * Gets the subjectCode of this Lab
    * 
    * @return this Lab's subjectCode
    */
   public String getSubjectCode() {
      return subjectCode;
   }
   
   /**
    * Changes the labNumber of this Lab
    * 
    * @param labNumber This Lab's new labNumber 
    */
   public void setLabNumber(int labNumber) {
      this.labNumber = labNumber;
   }
   
   /**
    * Gets the labNumber of this Lab
    * 
    * @return this Lab's labNumber
    */
   public int getLabNumber() {
      return labNumber;
   }
   
   /**
    * Changes the roomNumber of this Lab
    * 
    * @param roomNumber This Lab's new roomNumber 
    */
   public void setRoomNumber(String roomNumber) {
      this.roomNumber = roomNumber;
   }
   
   /**
    * Gets the roomNumber of this Lab
    * 
    * @return this Lab's roomNumber
    */
   public String getRoomNumber() {
      return roomNumber;
   }
   
   /**
    * Changes the tutorName of this Lab
    * 
    * @param tutorName This Lab's new tutorName 
    */
   public void setTutorName(String tutorName) {
      this.tutorName = tutorName;
   }
   
   /**
    * Gets the tutorName of this Lab
    * 
    * @return this Lab's tutorName
    */
   public String getTutorName() {
      return tutorName;
   }
   
   /**
    * Changes the labTime of this Lab
    * 
    * @param labTime This Lab's new labTime 
    */
   public void setLabTime(String labTime) {
      this.labTime = labTime;
   }
      
   /**
    * Gets the labTime of this Lab
    * 
    * @return this Lab's labTime
    */
   public String getLabTime() {
      return labTime;
   }
   
   /**
    * Changes the labCapacity of this Lab
    * 
    * @param labCapacity This Lab's new labCapacity 
    */
   public void setLabCapacity(int labCapacity) {
      this.labCapacity = labCapacity;
   }
      
   /**
    * Gets the labCapacity of this Lab
    * 
    * @return this Lab's labCapacity
    */
   public int getLabCapacity() {
      return labCapacity;
   }
   
   /**
    * Constructor for objects of class Lab
    */
   public Lab(String subjectCode, int labNumber, String roomNumber, String tutorName, String labTime, int labCapacity)
   {
       // initialise instance variables - subjectCode, labNumber, roomNumber, tutorName, labTime, labCapacity and studentList
       this.subjectCode = subjectCode;
       this.labNumber = labNumber;
       this.roomNumber = roomNumber;
       this.tutorName = tutorName;
       this.labTime = labTime;
       this.labCapacity = labCapacity;
       studentList = new ArrayList<Student>();
   }

   /**
    * Add Student to lab's list 
    *
    * @param  studentNumber  first paramter of addStudent method. Represents Student's number
    * @param  studentName second paramter of addStudent method. Represents Student's name
    */
   public boolean addStudent(int studentNumber, String studentName){
       if(findStudent(studentNumber) == null){
           Student newStudent = new Student(studentNumber, studentName);
           studentList.add(newStudent);
           return true;
       }
       else
           return false;
   }
   
   /**
    * Remove a student from lab's list 
    *
    * @param  studentNumber  first paramter of removeStudent method. Represents student's number
    * @return  boolean  if the student successfully removed then return true . Otherwise return false
    */
   public boolean removeStudent(int studentNumber){
      Student foundStudent = findStudent(studentNumber); 
      if(foundStudent != null){
          studentList.remove(foundStudent);
          return true;
      }
      else {
          return false;
      }
   }
   
   /**
    * Find a student from lab's list 
    *
    * @param  studentNumber  first paramter of findStudent method. Represents student's number
    * @return  Student  return the student if matches with the studentNumber. Otherwise return null
    */
   public Student findStudent(int studentNumber){
      for(Student student : studentList) {
          if(student.getNumber() == studentNumber){
              return student;
           }
      }
      return null;
   }
   
   /**
    * Number of Students associated with the lab 
    *
    * @return  the the number of students in the studentList
    */
   public int getNumberOfStudents(){
       return studentList.size();
   }
}
