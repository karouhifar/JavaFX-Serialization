// Name: Kamyab Rouhifar ID: 147742183

package student;

public class StudentException extends Exception {
    private final String studentErrorData;
    
    public StudentException(String studentErrorData) {
        this.studentErrorData = studentErrorData;
    }
    
    public String getStudentErrorData() {
        return studentErrorData;
    }
}
