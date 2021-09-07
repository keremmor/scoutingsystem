import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddButton extends JFrame{
    private JPanel panel1;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtTeam;
    private JTextField txtPosition;
    private JTextField txtCountry;
    private JTextField txtAge;
    private JButton OKButton;
    private JButton btnBack;
    private JFrame frame;

    public AddButton() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(txtAge.getText());
                CRUD crud = new CRUD();
                try {
                    crud.createPlayer(
                            txtName.getText(),
                            txtSurname.getText(),
                            txtTeam.getText(),
                            txtPosition.getText(),
                            txtCountry.getText(),
                            num);
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }

            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void frameSettings(String screenName , int width , int height , JPanel panelBase){
        frame = new JFrame(screenName);
        getFrame().setDefaultCloseOperation(EXIT_ON_CLOSE);
        getFrame().setSize(width,height);
        getFrame().add(panelBase);
        getFrame().setLocationRelativeTo(null);
        getFrame().setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
