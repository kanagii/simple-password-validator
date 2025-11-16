import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class passValidator extends JFrame {
    private JPanel mainPanel;
    private JTextField input;
    private JLabel askPassword;
    private JLabel statusText;
    private JButton verifyButton;
    private JLabel result;
    private JLabel missing;

    public passValidator(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean lengthTest = false;
                boolean upperCaseTest = false;
                boolean lowerCaseTest = false;
                boolean numberTest = false;
                boolean sCharTest = false;
                boolean passIsNotEmpty = false;

                String missingReqs = "<html>";

                String password = input.getText();
                int size = password.length();
                char[] array = new char[size];
                array = password.toCharArray();

                if (size >= 8)
                    lengthTest = true;
                if (!password.isEmpty())
                    passIsNotEmpty = true;

                for (char c : array) {
                    if (!Character.isLetter(c) && !Character.isDigit(c) && c != ' ')
                        sCharTest = true;
                    if (Character.isUpperCase(c))
                        upperCaseTest = true;
                    if (Character.isLowerCase(c))
                        lowerCaseTest = true;
                    if (Character.isDigit(c))
                        numberTest = true;

                }

                System.out.println("lengthTest " + lengthTest);
                System.out.println("upperCaseTest " + upperCaseTest);
                System.out.println("lowerCaseTest " + lowerCaseTest);
                System.out.println("numberTest " + numberTest);
                System.out.println("sCharTest " + sCharTest);
                System.out.println("emptyPassTest " + passIsNotEmpty);

                if(!passIsNotEmpty) {
                    missingReqs += "Type in your password.";
                } else {
                    if(!lengthTest)
                        missingReqs+="Password is too short<br>";
                    if(!upperCaseTest)
                        missingReqs+="Missing uppercase<br>";
                    if(!lowerCaseTest)
                        missingReqs+="Missing lowercase<br>";
                    if(!numberTest)
                        missingReqs+="Should include a number<br>";
                    if(!sCharTest)
                        missingReqs+="Include a special character";
                }

                missingReqs+="</html>";

                missing.setText(missingReqs);

                if (lengthTest && lowerCaseTest && upperCaseTest && numberTest && sCharTest && passIsNotEmpty) {
                    result.setText("Password is valid");
                } else {
                    result.setText("Password is not valid");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new passValidator("Kim's Pass Validator");
        frame.setVisible(true);
        frame.setLocation(680, 220);
    }
}
