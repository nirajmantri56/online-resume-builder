import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class resume extends JFrame implements ActionListener {
    // Declare variables
    private JLabel nameLabel, addressLabel, emailLabel, phoneLabel, skillsLabel, educationLabel;
    private JTextField nameTextField, addressTextField, emailTextField, phoneTextField, skillsTextField, educationTextField;
    private JButton submitButton, clearButton;

    public resume() {
        // Set JFrame properties
        setTitle("Resume Builder");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create panel and set layout
        JPanel panel = new JPanel();

        // Create labels and text fields
        nameLabel = new JLabel("Name: ");
        panel.add(nameLabel);
        nameTextField = new JTextField();
        // nameTextField.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);

        addressLabel = new JLabel("Address: ");
        addressTextField = new JTextField();
        emailLabel = new JLabel("Email: ");
        emailTextField = new JTextField();
        phoneLabel = new JLabel("Phone: ");
        phoneTextField = new JTextField();
        
        skillsLabel = new JLabel("Skills: ");
        skillsTextField = new JTextField();
        educationLabel = new JLabel("Education: ");
        educationTextField = new JTextField();

        // Create buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        // Add action listeners to buttons
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(addressLabel);
        panel.add(addressTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(phoneLabel);
        panel.add(phoneTextField);
        panel.add(skillsLabel);
        panel.add(skillsTextField);
        panel.add(educationLabel);
        panel.add(educationTextField);
        panel.add(submitButton);
        panel.add(clearButton);

        // Add panel to JFrame
        add(panel);

        // Set JFrame visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Get values from text fields
            String name = nameTextField.getText();
            String address = addressTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            String skills = skillsTextField.getText();
            String education = educationTextField.getText();

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
                Paragraph para7 = new Paragraph("Education: " + education);

                document.add(para1);
                document.add(para2);
                document.add(para3);
                document.add(para4);
                document.add(para6);
                document.add(para7);
    
                // Close PDF document
                document.close();
                writer.close();
    
                JOptionPane.showMessageDialog(this, "Resume saved as PDF!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == clearButton) {
            // Clear text fields
            nameTextField.setText("");
            addressTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            skillsTextField.setText("");
            educationTextField.setText("");
        }
    }
    
    public static void main(String[] args) {
        new resume();
    }
    
}
