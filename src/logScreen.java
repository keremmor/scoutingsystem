import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logScreen extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton logButton;
    String username;
    String password;

    public logScreen() {
        setTitle("Login Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 250);
        setResizable(false);
        add(panel1);
        setLocationRelativeTo(null);
        setVisible(true);
        checkUser();
    }

    public void checkUser() {
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = textField1.getText();
                char[] a = passwordField1.getPassword();
                password = new String(a);

                if (username.equals("admin") && password.equals("Password1245**")) {
                    JOptionPane.showMessageDialog(null, "You logged succesfully  !");
                    dispose();
                    PlayersList playersList = new PlayersList();

                } else {
                    JOptionPane.showMessageDialog(null, "Password or username is wrong !");

                }
            }
        });
    }

}
