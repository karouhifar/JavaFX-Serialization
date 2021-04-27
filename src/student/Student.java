// Name: Kamyab Rouhifar ID: 147742183

package student;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses = new ArrayList<>();
    
    
    // ----------------------- Constructor no Parameters
    public Student() {
        this.stdID = 0;
        this.firstName = null;
        this.lastName = null;
        this.courses = new ArrayList<>();
    }
    
    // ----------------------- Constructor with  Parameters
    public Student(int stdIDData, String firstNameData, String lastNameData, String coursesData) throws StudentException {
        if (stdIDData > 0 && firstNameData.length() > 0 && lastNameData.length() > 0 && !coursesData.isEmpty()) {
            this.stdID = stdIDData;
            this.firstName = firstNameData;
            this.lastName = lastNameData;
            this.courses.add(coursesData);
        } else {
            throw new StudentException("Invalid Student data\n");
        }
    }
    
    // ******************************** SETTERS AND GETTERS ********************************//
    //-----------------------  Setters
    public void setStdID(int stdIDData) throws StudentException {
        if (stdIDData > 0)
            this.stdID = stdIDData;
        else
            throw new StudentException("Invalid stdID\n");
    }
    
    //---
    public void setFirstName(String firstNameData) throws StudentException {
        if (firstNameData.length() > 0)
            this.firstName = firstNameData;
        else
            throw new StudentException("Invalid FirstName\n");
    }
    
    //---
    public void setLastName(String lastNameData) throws StudentException {
        if (lastNameData.length() > 0)
            this.lastName = lastNameData;
        else
            throw new StudentException("Invalid LastName\n");
    }
    
    //---
    public void setCourses(String coursesData) throws StudentException {
        if (coursesData.length() > 0)
            this.courses.add(coursesData);
        else
            throw new StudentException("Invalid Courses\n");
    }
    
    //-----------------------  Getters
    public int getStdID() {
        return stdID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public ArrayList<String> getCourses() {
        return courses;
    }
    
    
    // ****************************************************************//
    //----------------------------------------------------------------------------
    @Override
    public String toString() {
        
        return String.format("\n ID: %d \n First Name: %s \n Last Name: %s \n Course(s): %s\n"
                , getStdID(), getFirstName(), getLastName(), getCourses());
    }
}


