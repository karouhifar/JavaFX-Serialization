// Name: Kamyab Rouhifar ID: 147742183

package student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Deserialization extends JFrame {
    public static void main(String[] args) {
        
        String[] nameData = {"Kamyab", "Rouhifar"};
        
        //  --- Making frame &  frame layout --- //
        JFrame frame = new JFrame("Deserialization");
        Box box = Box.createHorizontalBox();
        frame.setLayout(new FlowLayout());
        //---------------------------------------------------------------------//
        //  --- Making textArea  --- //
        JTextArea textArea = new JTextArea(null, 15, 25);
        box.add(new JScrollPane(textArea));
        textArea.setEditable(false);
        frame.add(box);
        //---------------------------------------------------------------------//
        JButton buttonInfo = new JButton("Information");
        frame.add(buttonInfo);
        
        JButton buttonClear = new JButton("Clear");
        frame.add(buttonClear);
        //---------------------------------------------------------------------//
        Icon image = new ImageIcon(Deserialization.class.getResource("kamyab.jpg"));
        JLabel label = new JLabel("Designed by " + nameData[0] + " " + nameData[1], image,
                SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setForeground(Color.RED);
        frame.add(label);
        
        //---------------------------------------------------------------------//
        buttonInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    
                    FileInputStream fis = new FileInputStream("Student.out");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ArrayList<Student> student = (ArrayList<Student>) ois.readObject();
                    textArea.append("We have " + student.size() + " student object(s) in class\n");
                    // ---  Add Data to textArea
                    for (Student value : student) {
                        textArea.append("\n----------\n" + value);
                    }
                    // --- Clear ArrayList and Input file and object
                    student.clear();
                    fis.close();
                    ois.close();
                } catch (IOException | ClassNotFoundException | IllegalStateException error) {
                    System.err.println(error);
                }
            }
        });
        //---------------------------------------------------------------------//
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        //---------------------------------------------------------------------//
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        
        
    }
    
}
