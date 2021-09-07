import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayersList extends JFrame {
    private JButton btnAddPlayer;
    private JButton btnRemovePlayer;
    private JTable table1;
    private JPanel panelAll;
    private JPanel panel2;
    private JPanel panel3;
    private JButton btnRefresh;
    private JComboBox boxCombo;
    private JTextField textField1;
    private JFrame frame;

    DefaultTableModel model;

    public PlayersList() {
        tableSettings();
        setBoxCombo();
        try {
            ArrayList<Player> players = getPlayers();
            for (Player player : players) {
                Object[] row = {
                        player.getFirst_name(),
                        player.getSurname(),
                        player.getTeam(),
                        player.getPosition(),
                        player.getCountry(),
                        player.getAge(),
                        player.getId()};
                model.addRow(row);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        frameSettings("Players List", 550, 500, getPanelAll());

        btnAddPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddButton button = new AddButton();
                button.frameSettings("Add Screen", 400, 450, button.getPanel1());
            }
        });
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                PlayersList playersList = new PlayersList();
            }
        });
        btnRemovePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveButton button = new RemoveButton();
                button.frameSettings("Remove Screen", 400, 450, button.getPanel1());
            }
        });
        boxCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public ArrayList<Player> getPlayers() throws SQLException {
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Player> players = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from players");
            players = new ArrayList<Player>();
            while (resultSet.next()) {
                players.add(new Player(resultSet.getString("first_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("team"),
                        resultSet.getString("position"),
                        resultSet.getString("country"),
                        resultSet.getInt("age"),
                        resultSet.getInt("id")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

        return players;
    }

    public void tableSettings() {
        model = (DefaultTableModel) table1.getModel();
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Team");
        model.addColumn("Position");
        model.addColumn("Country");
        model.addColumn("Age");
        model.addColumn("ID");
        table1.setRowHeight(20);
        TableColumnModel columnModel = table1.getColumnModel();
    }

    public void frameSettings(String screenName, int width, int height, JPanel panelBase) {
        frame = new JFrame(screenName);
        getFrame().setDefaultCloseOperation(EXIT_ON_CLOSE);
        getFrame().setSize(width, height);
        getFrame().add(panelBase);
        getFrame().setLocationRelativeTo(null);
        getFrame().setVisible(true);
    }

    private void createUIComponents() {


    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanelAll() {
        return panelAll;
    }

    public void setBoxCombo(){
        boxCombo.addItem("Name");
        boxCombo.addItem("Surname");
        boxCombo.addItem("Team");
        boxCombo.addItem("Country");
        boxCombo.addItem("Position");
        boxCombo.addItem("Age");
        boxCombo.addItem("ID");
    }

}
