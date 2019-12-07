import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class connection {
    String url = "jdbc:mysql://localhost:3306/bd_orcamento_domestico";
    String usuario = "root";
    String senha = "vertrigo";


    private final Statement stm = null;
    private Connection conexao = null;
    public static Statement statement = null;

    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection(url, usuario, senha);
        statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    public void desconectar() throws SQLException{
        conexao.close();
    }

    public static int RunSQL(String sql){
        int qtreg = 0;
        try{
            qtreg = statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registro processado");
        }
        catch (SQLException sqlex){
            System.out.println("Erro de acesso ao Banco de Dados " + sqlex);
            JOptionPane.showMessageDialog(null, "Erro.");
        }
        return qtreg;
    }
}
