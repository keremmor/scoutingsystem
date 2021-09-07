import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RemoveButton {
    private JPanel panel1;
    private JButton btnBack;
    private JTextField textField1;
    private JButton btnRemove;
    private JFrame frame;

    public RemoveButton() {
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(textField1.getText());
                CRUD crud = new CRUD();
                try {
                    crud.deletePlayer(num);
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

    public JPanel getPanel1() {
        return panel1;
    }
}
