import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentInformationSystem1 extends JFrame {
    private JTextField fullnameField, rollNumberField, percentageField, dobField, phoneField, emailField;
    private JComboBox<String> courseComboBox, yearComboBox;
    private JTextArea outputArea;
    private ArrayList<Student> students = new ArrayList<>();
    private int serialNumber = 1;

    public StudentInformationSystem1() {
        setTitle("Student Information System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel fullnameLabel = new JLabel("Full Name:");
        inputPanel.add(fullnameLabel, constraints);

        constraints.gridx = 1;
        fullnameField = new JTextField(20);
        inputPanel.add(fullnameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        inputPanel.add(rollNumberLabel, constraints);

        constraints.gridx = 1;
        rollNumberField = new JTextField(20);
        inputPanel.add(rollNumberField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel dobLabel = new JLabel("Date of Birth:");
        inputPanel.add(dobLabel, constraints);

        constraints.gridx = 1;
        dobField = new JTextField(20);
        inputPanel.add(dobField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        JLabel courseLabel = new JLabel("Course:");
        inputPanel.add(courseLabel, constraints);

        constraints.gridx = 1;
        String[] courseOptions = {"Btech", "Mtech", "MCA", "MBA", "BE", "ME"};
        courseComboBox = new JComboBox<>(courseOptions);
        inputPanel.add(courseComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        JLabel yearLabel = new JLabel("Year:");
        inputPanel.add(yearLabel, constraints);

        constraints.gridx = 1;
        String[] yearOptions = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
        yearComboBox = new JComboBox<>(yearOptions);
        inputPanel.add(yearComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        JLabel phoneLabel = new JLabel("Phone Number:");
        inputPanel.add(phoneLabel, constraints);

        constraints.gridx = 1;
        phoneField = new JTextField(20);
        inputPanel.add(phoneField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        JLabel emailLabel = new JLabel("Email Id:");
        inputPanel.add(emailLabel, constraints);

        constraints.gridx = 1;
        emailField = new JTextField(20);
        inputPanel.add(emailField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        JLabel percentageLabel = new JLabel("Percentage:");
        inputPanel.add(percentageLabel, constraints);

        constraints.gridx = 1;
        percentageField = new JTextField(20);
        inputPanel.add(percentageField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton, constraints);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullname = fullnameField.getText();
                String rollNumber = rollNumberField.getText();
                String dob = dobField.getText();
                String course = (String) courseComboBox.getSelectedItem();
                String year = (String) yearComboBox.getSelectedItem();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String percentage = percentageField.getText();
                if (!fullname.isEmpty() && !rollNumber.isEmpty() && !dob.isEmpty() && !phone.isEmpty() && !email.isEmpty() && !percentage.isEmpty()) {
                    Student student = new Student(serialNumber, fullname, rollNumber, dob, course, year, phone, email, percentage);
                    students.add(student);
                    serialNumber++;
                    updateOutput();
                    fullnameField.setText("");
                    rollNumberField.setText("");
                    dobField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    percentageField.setText("");
                }
            }
        });
    }

    private void updateOutput() {
        outputArea.setText("Sno\tFull Name\tRoll Number\tDate of Birth\tCourse\tYear\tPhone Number\tEmail\tPercentage\n");
        for (Student student : students) {
            outputArea.append(student.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentInformationSystem1 studentInfoSystem = new StudentInformationSystem1();
            studentInfoSystem.setVisible(true);
        });
    }

    private class Student {
        private int sno;
        private String fullname;
        private String rollNumber;
        private String dob;
        private String course;
        private String year;
        private String phone;
        private String email;
        private String percentage;

        public Student(int sno, String fullname, String rollNumber, String dob, String course, String year, String phone, String email, String percentage) {
            this.sno = sno;
            this.fullname = fullname;
            this.rollNumber = rollNumber;
            this.dob = dob;
            this.course = course;
            this.year = year;
            this.phone = phone;
            this.email = email;
            this.percentage = percentage;
        }

        @Override
        public String toString() {
            return String.format("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", sno, fullname, rollNumber, dob, course, year, phone, email, percentage);
        }
    }
}