import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class connection {
    String url = "jdbc:mysql://localhost:3306/bd_biblioteca"; //Só vai funcionar depois de colocar o BD no servidor local
    String usuario = "root"; //Não sei como fica no Postgre, alguém tem que testar essa conexão. Acredito que seja root e root, ou admin e admin, ou root admin, ou admin root, ou apenas root ou apenas admin. Geralmente alguma dessas opções funcionam.
    String senha = "vertrigo"; //O mesmo da linha de cima


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
            System.out.println("Erro ao acessar o banco de dados: " + sqlex);
            JOptionPane.showMessageDialog(null, "Erro.");
        }
        return qtreg;
    }
}
