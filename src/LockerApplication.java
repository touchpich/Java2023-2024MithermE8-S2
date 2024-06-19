import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame {

    private JLabel titleLabel;
    private JLabel statusLabel;
    private JPasswordField passwordField;
    private JButton enterButton;
    private JTextArea messageArea;

    private String password;
    private boolean passwordSet;

    public LockerApplication() {
        super("Locker Application");

        titleLabel = new JLabel("Enter Password:");
        statusLabel = new JLabel("Status:");
        passwordField = new JPasswordField(20);
        enterButton = new JButton("Enter");
        messageArea = new JTextArea(5, 20);
        messageArea.setEditable(false);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(titleLabel);
        add(passwordField);
        add(enterButton);
        add(statusLabel);
        add(new JScrollPane(messageArea));

        password = "";
        passwordSet = false;

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!passwordSet) {
                    setPassword();
                } else {
                    verifyPassword();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setPassword() {
        char[] input = passwordField.getPassword();
        password = new String(input);
        passwordSet = true;
        messageArea.append("Password Set\n");
        clearPasswordField();
    }

    private void verifyPassword() {
        char[] input = passwordField.getPassword();
        String inputPassword = new String(input);
        if (inputPassword.equals(password)) {
            messageArea.append("Correct Password\n");
        } else {
            messageArea.append("Incorrect Password\n");
        }
        clearPasswordField();
    }

    private void clearPasswordField() {
        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LockerApplication();
            }
        });
    }
}