import java.util.*;
/**
 * LabMaster is responsible for maintaining the list of labs for different subjects.
 *
 * @author Upal Roy
 * @version 1.0.0
 */
public class LabMaster
{
    // instance variables - labList represent list of lab in the LabMaster
    private ArrayList<Lab> labList;

    /**
     * Constructor for objects of class LabMaster
     */
    public LabMaster()
    {
        // initialise instance variables - labList
        labList = new ArrayList<Lab>();
    }
    
   /**
    * Add lab to LabMaster's list 
    *
    * @param  newLab  first paramter of addLab method. Represents new lab object
    */
   public void addLab(Lab newLab){
       labList.add(newLab);
   }
   
   /**
    * Remove a lab from LabMaster's list 
    *
    * @param  subjectCode  first paramter of removeLab method. Represents subject code
    * @param  labNumber  second paramter of removeLab method. Represents lab number
    * @return  boolean  if the lab successfully removed then return true . Otherwise return false
    */
   public int removeLab(String subjectCode, int labNumber){
      Lab foundLab = findLab(subjectCode, labNumber); 
      if(foundLab != null && foundLab.getNumberOfStudents() == 0){
          labList.remove(foundLab);
          return 1;
      }
      else if (foundLab == null)
          return 2;
      else if (foundLab.getNumberOfStudents() > 0)
          return 3;
      return 0;    
   }
   
   /**
    * Find available Labs 
    *
    * @return  availableLabList  return the available Lab List 
    */
   public ArrayList<Lab> listOfAvailableLabs(){
      ArrayList<Lab> availableLabList = new ArrayList<Lab>(); 
      for(Lab lab : labList) {
          if(lab.getNumberOfStudents() < lab.getLabCapacity()){
              availableLabList.add(lab);
          }
      }
      return availableLabList;
   }
   
   /**
    * Find fully booked Labs for a specific subject 
    *
    * @param  subjectCode  first paramter of listofAvailableLabs method. Represents subject code
    * @return  fullyBookedLabList  return fully booked labs' List
    */
   public ArrayList<Lab> listofFullyBookedLabs(String subjectCode){
      ArrayList<Lab> fullyBookedLabList = new ArrayList<Lab>(); 
      for(Lab lab : labList) {
          if(lab.getSubjectCode().equals(subjectCode) && lab.getNumberOfStudents() == lab.getLabCapacity()){
              fullyBookedLabList.add(lab);
          }
      }
      return fullyBookedLabList;
   }
   
   /**
    * Find a Lab from LabMaster's list 
    *
    * @param  subjectCode  first paramter of removeLab method. Represents subject code
    * @param  labNumber  second paramter of removeLab method. Represents lab number
    * @return  Lab  return the lab if matches with the subjectCode and labNumber. Otherwise return null
    */
   public Lab findLab(String subjectCode, int labNumber){
      for(Lab lab : labList) {
          if(lab.getSubjectCode().equals(subjectCode) && lab.getLabNumber() == labNumber){
              return lab;
          }
      }
      return null;
   }
   
   /**
    * Find the Lab where student is enrolled for specific subject 
    *
    * @param  subjectCode  first paramter of inWhichLabStudentRegisteredForThisSubject method. Represents subject code
    * @param  studentNumber  second paramter of inWhichLabStudentRegisteredForThisSubject method. Represents student number
    * @return  Lab  return the lab if matches with the condition. Otherwise return null
    */
   public Lab inWhichLabStudentRegistered(String subjectCode, int studentNumber){
       ArrayList<Lab> allLabsForASubject = findLabsBySubjectCode(subjectCode);
       if(allLabsForASubject.size() >  0){
           for(Lab lab : allLabsForASubject) {
               if(lab.findStudent(studentNumber) != null){
                   return lab;
               }
           }
       }
       return null;
   }
   
   /**
    * Remove the student from his registerd lab
    *
    * @param  subjectCode  first paramter of removeStudentFromLab method. Represents subject code
    * @param  studentNumber  second paramter of removeStudentFromLab method. Represents student number
    * @return  boolean  return true if student removal is successfull. Otherwise return false
    */
   public boolean removeStudentFromLab(String subjectCode, int studentNumber){
       ArrayList<Lab> allLabsForASubject = findLabsBySubjectCode(subjectCode);
       if(allLabsForASubject.size() >  0){
           for(Lab lab : allLabsForASubject) {
               if(lab.removeStudent(studentNumber)){
                   return true;
               }
           }
       }
       return false;
   }
   
   /**
    * Find all the labs booked by a student for different subjects
    *
    * @param  studentNumber  first paramter of allLabsBookedForAStudent method. Represents student number
    * @return  ArrayList  return list of booked labs for different subjects for a specific student.
    */
   public ArrayList<Lab> allLabsBookedForAStudent(int studentNumber){
       ArrayList<Lab> bookedLabList = new ArrayList<Lab>();
       for(Lab lab : labList) {
           if(lab.findStudent(studentNumber) != null){
               bookedLabList.add(lab);
           }
       }
       return bookedLabList;
   }
   
   /**
    * Find all the labs under a specific subject
    *
    * @param  subjectCode  first paramter of findLabsBySubjectCode method. Represents subject code
    * @return  ArrayList  return list of labs under a specific subject.
    */
   public ArrayList<Lab> findLabsBySubjectCode(String subjectCode){
      ArrayList<Lab> allLabsForASubject = new ArrayList<Lab>();  
      for(Lab lab : labList) {
          if(lab.getSubjectCode().equals(subjectCode)){
              allLabsForASubject.add(lab);
          }
      }
      return allLabsForASubject;
   }
}
