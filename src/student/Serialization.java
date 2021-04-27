// Name: Kamyab Rouhifar ID: 147742183


package student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class Serialization extends JFrame {
    
    
    public static void main(String[] args) {
        
        
        // Creating a sizable array for adding more objects
        ArrayList<Student> listStudent = new ArrayList<>();
        
        //  --- Making frame &  frame groupLayout --- //
        JFrame frame = new JFrame("Serialization");
        var panel = frame.getContentPane();
        GroupLayout groupLayout = new GroupLayout(panel);
        panel.setLayout(groupLayout);
        //---------------------------------------------------------------------//
        // --- Making Label & TextField & adding to JFrame class--- //
        
        // --- Student ID
        JLabel ID = new JLabel();
        ID.setText("Enter Student ID: ");
        JTextField IDField = new JTextField(15);
        frame.add(ID);
        frame.add(IDField);
        //---- FirstName
        JLabel firstName = new JLabel();
        firstName.setText("Enter Student First Name: ");
        JTextField firstField = new JTextField(15);
        frame.add(firstName);
        frame.add(firstField);
        // --- LastName
        JLabel lastName = new JLabel();
        lastName.setText("Enter Student Last Name: ");
        JTextField lastField = new JTextField(15);
        frame.add(lastName);
        frame.add(lastField);
        //---- Courses
        JLabel course = new JLabel();
        course.setText("Enter Student courses (comma delimiter): ");
        JTextField courseField = new JTextField(15);
        frame.add(course);
        frame.add(courseField);
  
        //---------------------------------------------------------------------//
        // ---  Send Information Button & add the button to JFrame
        JButton sendButton = new JButton("Send Information");
        sendButton.setForeground(Color.white);
        sendButton.setBackground(Color.blue);
        frame.add(sendButton);
        // ---  Send cancel Button ( Termination ) & add the button to JFrame
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.white);
        cancelButton.setBackground(Color.blue);
        frame.add(cancelButton);
        
        //---------------------------------------------------------------------//
        // --- Layout Organization --- //
        
        // ---  automatic gap insertion
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        
        // --- Establishing a root group & Sizing in Parallel Groups
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(LEADING)
                        .addComponent(ID)
                        .addComponent(firstName)
                        .addComponent(lastName)
                        .addComponent(course)
                        .addComponent(sendButton)
                        .addComponent(cancelButton)
                )
                .addGroup(groupLayout.createParallelGroup(LEADING)
                        .addComponent(IDField)
                        .addComponent(firstField)
                        .addComponent(lastField)
                        .addComponent(courseField))
        
        );
        
        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(BASELINE)
                        .addComponent(ID)
                        .addComponent(IDField))
                .addGroup(groupLayout.createParallelGroup(BASELINE)
                        .addComponent(firstName)
                        .addComponent(firstField))
                .addGroup(groupLayout.createParallelGroup(BASELINE)
                        .addComponent(lastName)
                        .addComponent(lastField))
                .addGroup(groupLayout.createParallelGroup(BASELINE)
                        .addComponent(course)
                        .addComponent(courseField))
                .addComponent(sendButton)
                .addComponent(cancelButton)
        
        );
        
        
        // --- Making Components the Same Size
        groupLayout.linkSize(SwingConstants.HORIZONTAL, sendButton, cancelButton);
        frame.pack();
        
        //---------------------------------------------------------------------//
        // --- Exit The application without running it in background
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // --- making a frame size & window size
        frame.setSize(500, 500);
//        frame.pack();
        // --- Making all texts and fields visible
        frame.setVisible(true);
        // ---------------------------------------------------------------------//
        // --- Starting Action Event and Create a new object of type Student
        sendButton.addActionListener(new ActionListener() {
          
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    
                    int stdID = Integer.parseInt(IDField.getText());
                    String firstName = firstField.getText();
                    String lastName = lastField.getText();
                    String courses = courseField.getText();
                    
                    // Creating a new object of type Student class
                    Student student = new Student();
                    // --- Setting JTextField data to the object
                    student.setStdID(stdID);
                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    String[] tokens = courses.split(",");
                    for (String token : tokens) {
                        student.setCourses(token);
                    }
                    // Adding object to student arrayList
                    listStudent.add(student);
                    //------------------------------------
                    // ---  Saving to "student.out" in command line argument
                    
                    FileOutputStream fileOutput = new FileOutputStream(args[0]);
                    ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
                    objectOutput.writeObject(listStudent);
                    objectOutput.flush();
                    fileOutput.close();
                    objectOutput.close();
                    
                    // --- Clear all fields for a next object
                    IDField.setText("");
                    firstField.setText("");
                    lastField.setText("");
                    courseField.setText("");
                    //------------------------------------
                    JLabel submission = new JLabel();
                    submission.setText(" Student added !!!");
                    submission.setForeground(Color.green);
                    submission.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
                    frame.add(submission);
                    
                    groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                            .addComponent(submission, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    
                    );
                    groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                            .addComponent(submission, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    );
                    //------------------------------------
                } catch (IndexOutOfBoundsException error) {
                    System.out.println("Data is out of Bounds: " + error.getMessage());
                    System.out.println("Please try again");
                } catch (IOException error) {
                    System.err.println("ERROR IN READING CONSOLE: " + error.getMessage());
                    System.out.println("Please try again");
                } catch (StudentException error) {
                    System.err.println(error.getStudentErrorData());
                    System.out.println("Please try again");
                } catch (IllegalArgumentException | IllegalStateException error) {
                    System.err.println(error.getMessage());
                    System.out.println("Please try again");
                }
            }
        });
        // ---------------------------------------------------------------------//
        // --- Exit program Event
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    
}
