import javax.swing.*;
import java.sql.*;

public class connection {
    public static Connection connection;
    public static Statement statement = null;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ep bd?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "vertrigo");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível encontrar o Driver!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível conectar ao banco!");
        }
        return connection;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static int runQuerie(String sql) {
        int qtreg = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Registro processado");
        } catch (SQLException sqlex) {
            System.out.println("Erro ao acessar o banco de dados: " + sqlex);
            JOptionPane.showMessageDialog(null, "Erro.");
        }
        return qtreg;
    }
}
