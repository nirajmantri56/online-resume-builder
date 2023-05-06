import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class builder extends JFrame implements ActionListener{

    JButton imageButton;
    JButton cancel,submit;
    JLabel name, email, phone, address, skills, linkdin, leetcode, image;
    JTextField nameTextField, emailTextField, phoneTextField, addressTextField, skillsTextField, linkdinTextField, leetcodeTextField;

    public builder(){
        setSize(850, 700);
        setLayout(null);

        JLabel label = new JLabel("RESUME BUILDER FOR FRESHER");
        label.setFont(new Font("Osward", Font.BOLD, 35));
        label.setBounds(130, 40, 700, 40);
        add(label);

         name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds( 140, 140, 100, 30);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(250, 140, 400, 30);
        add(nameTextField);

         email = new JLabel("E-mail:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds( 140, 190, 100, 30);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(250, 190, 400, 30);
        add(emailTextField);

         phone = new JLabel("Phone No:");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds( 140, 240, 100, 30);
        add(phone);

         phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        phoneTextField.setBounds(250, 240, 400, 30);
        add(phoneTextField);

         address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds( 140, 290, 100, 30);
        add(address);

         addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(250, 290, 400, 30);
        add(addressTextField);

         skills = new JLabel("Skills:");
        skills.setFont(new Font("Raleway", Font.BOLD, 20));
        skills.setBounds( 140, 340, 100, 30);
        add(skills);

         skillsTextField = new JTextField();
        skillsTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        skillsTextField.setBounds(250, 340, 400, 30);
        add(skillsTextField);

         linkdin = new JLabel("LinkedIn:");
        linkdin.setFont(new Font("Raleway", Font.BOLD, 20));
        linkdin.setBounds( 140, 390, 150, 30);
        add(linkdin);

        JLabel url1 = new JLabel("URL");
        url1.setFont(new Font("Raleway", Font.BOLD, 20));
        url1.setBounds( 148, 410, 150, 30);
        add(url1);

         linkdinTextField = new JTextField();
        linkdinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        linkdinTextField.setBounds(250, 390, 300, 30);
        add(linkdinTextField);

         leetcode = new JLabel("Leetcode:");
        leetcode.setFont(new Font("Raleway", Font.BOLD, 20));
        leetcode.setBounds( 140, 440, 150, 30);
        add(leetcode);

        JLabel url2 = new JLabel("URL");
        url2.setFont(new Font("Raleway", Font.BOLD, 20));
        url2.setBounds( 148, 460, 150, 30);
        add(url2);

         leetcodeTextField = new JTextField();
        leetcodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        leetcodeTextField.setBounds(250, 440, 300, 30);
        add(leetcodeTextField);

        JLabel url3 = new JLabel("(Or any other. ex.GFG, Hackerrank, Hackerearth,etc)");
        url3.setFont(new Font("Raleway", Font.PLAIN, 10));
        url3.setBounds( 250, 470, 300, 15);
        add(url3);

         image = new JLabel("Image :");
        image.setFont(new Font("Raleway", Font.BOLD, 20));
        image.setBounds( 140, 510, 250, 30);
        add(image);

        imageButton = new JButton("Select");
        imageButton.setBounds(250, 510, 80, 25);
        imageButton.setFont(new Font("Raleway", Font.BOLD, 12));
        setFocusable(false);
        add(imageButton);
        imageButton.addActionListener(this);

        submit = new JButton("Submit", null);
        submit.setBounds(300, 585, 80, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        setFocusable(false);
        add(submit);
        submit.addActionListener(this);

        cancel = new JButton("Cancel", null);
        cancel.setBounds(400, 585, 80, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        setFocusable(false);
        add(cancel);
        cancel.addActionListener(this);

        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new builder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == imageButton){
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    ImageIcon i1 = new ImageIcon(selectedFile.getAbsolutePath());
                    Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                    ImageIcon i3 = new ImageIcon(i2);
                    JLabel label = new JLabel(i3);
                    label.setBounds(350, 510, 30, 30);
                    add(label);
                    JOptionPane.showMessageDialog(null, "Done");
                } 
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        else if(e.getSource() == submit){
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            String address = addressTextField.getText();
            String skills = skillsTextField.getText();
            String linkedin = linkdinTextField.getText();
            String leetcode = leetcodeTextField.getText();

            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email ID is Required");
            }
            if(phone.equals("")){
                JOptionPane.showMessageDialog(null, "Phone number is Required");
            }
            if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            if(skills.equals("")){
                JOptionPane.showMessageDialog(null, "Skills is/are Required");
            }
            if(linkedin.equals("")){
                JOptionPane.showMessageDialog(null, "LinkedIn URL is Required");
            }
            if(leetcode.equals("")){
                JOptionPane.showMessageDialog(null, "Leetcode/ GFG/ Hackerearth URL is Required");
            }

            // Create PDF or DOC document
            Document document = new Document();
            try {
                // Create PDF document
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("resume.pdf"));
                document.open();

                // Add content to PDF document
                Paragraph para1 = new Paragraph("Name: " + name);
                Paragraph para2 = new Paragraph("Address: " + address);
                Paragraph para3 = new Paragraph("Email: " + email);
                Paragraph para4 = new Paragraph("Phone: " + phone);
                Paragraph para6 = new Paragraph("Skills: " + skills);
                // Paragraph para7 = new Paragraph("Education: " + education);

                document.add(para1);
                document.add(para2);
                document.add(para3);
                document.add(para4);
                document.add(para6);
                // document.add(para7);
    
                // Close PDF document
                document.close();
                writer.close();
    
                JOptionPane.showMessageDialog(this, "Resume saved as PDF!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        else if(e.getSource() == cancel){
            setVisible(false);
            JOptionPane.showMessageDialog(null, "Thank you for Visiting! \n Hope you come back Soon :)");
        }
    }
}
