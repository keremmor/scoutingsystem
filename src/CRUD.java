import javax.swing.*;
import java.sql.Connection;
import java.sql.*;

public class CRUD {
     public void updateTeam(String team , int id) throws SQLException{
        DBHelper helper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "update players set team =?  where id=?";
            connection = helper.getConnection();
            statement = ((Connection) connection).prepareStatement(sql);
            statement.setInt(2,id);
            statement.setString(1,team);
            statement.executeUpdate();
            System.out.println("Player's team is updated succesfully.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }

    public void createPlayer(String name ,String surname ,String team ,String pos , String country ,int age) throws SQLException{
        DBHelper helper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "insert into players (first_name,surname,team,position,country,age) values(?,?,?,?,?,?)";
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.setString(3,team);
            statement.setString(4,pos);
            statement.setString(5,country);
            statement.setInt(6,age);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Player added to database succesfully\nPlease do not forget to refresh the list after the operation !");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
            JOptionPane.showMessageDialog(null, "Error : Player could not added to database.\nPlease do not forget to refresh the list after the operation !");
        } finally {
            connection.close();
        }

    }

    public void deletePlayer(int id) throws SQLException{
        DBHelper helper = new DBHelper();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String sql = "delete from players where id=?";
            connection = helper.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Player is deleted succesfully.\nPlease do not forget to refresh the list after the operation !");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close();
        }
    }
}
