import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form {
    public JPanel panel;
    private JButton localizePublicationButton;
    private JTextPane textPane;
    private JTextField textField1;
    private JButton ALPHABETARYPUBLICATIONSBYAUTHORButton;
    private JButton ALPHABETARYPUBLICATIONSBYTHEMEButton;
    private JButton ALPHABETARYPUBLICATIONSBYTITLEButton;
    private JButton ANNUALCONFERENCEARTICLEButton;
    private JButton CHRONOLOGICALORDERARTICLECONSTITUTINGButton;
    private JButton ARTICLESOFANAUTHORButton;
    private JButton AUTHORSOFONETHEMEButton;
    private JButton USERTHATLENTPUBLICATIONButton;

    private static JFrame frame;

    public form() {
        ARTICLESOFANAUTHORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String query = "SELECT publicacao.titulo FROM publicacao NATURAL JOIN criacao NATURAL JOIN autor WHERE autor.nome = \"" + input + "\" ORDER BY publicacao.data ASC";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    string.append("ARTICLES OF AN AUTHOR\n\n");
                    string.append("TITULO\n");
                    String textPaneText = textPane.getText();
                    string.append(textPaneText + "\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        ALPHABETARYPUBLICATIONSBYTITLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String query = "SELECT titulo FROM publicacao ORDER BY titulo ASC";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();


                    string.append("ALPHABETARY PUBLICATIONS BY TITLE\n\n");
                    string.append("TITULO\n");
                    String textPaneText = textPane.getText();
                    string.append(textPaneText + "\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        ALPHABETARYPUBLICATIONSBYTHEMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String query = "SELECT titulo,Assunto FROM Tema NATURAL JOIN Publicacao ORDER BY assunto ASC";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    String textPaneText = textPane.getText();
                    string.append(textPaneText);

                    string.append("ALPHABETARY PUBLICATIONS BY THEME\n\n");
                    string.append("TITULO\tASSUNTO\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        localizePublicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String query = "SELECT rua, cidade FROM Endereco NATURAL JOIN Publicacao WHERE titulo = \"" + input + "\"";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    String textPaneText = textPane.getText();
                    string.append(textPaneText);

                    string.append("LOCATE PUBLICATION\n\n");
                    string.append("RUA\tCIDADE\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        CHRONOLOGICALORDERARTICLECONSTITUTINGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String[] aux = input.split(" ");
                    String query = "SELECT DISTINCT publicacao.titulo FROM publicacao INNER JOIN periodico WHERE publicacao.cod_publicacao = (SELECT cod_publicacao from periodico where periodico.titulo = '" + aux[0] + "') AND publicacao.data BETWEEN '" + aux[1] + "' AND '" + aux[2] + "' AND publicacao.cod_tipoPublicacao = 1 ORDER BY data";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    String textPaneText = textPane.getText();
                    string.append(textPaneText);

                    string.append("CHRONOLOGICAL ORDER ARTICLE CONSTITUTING A PERIOD\n\n");
                    string.append("TITULO\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        AUTHORSOFONETHEMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String[] aux = input.split(" ");
                    String query = "SELECT publicacao.titulo, autor.nome FROM Criacao NATURAL JOIN Autor NATURAL JOIN Publicacao WHERE publicacao.cod_tema = (SELECT cod_tema FROM tema WHERE assunto = '" + input + "') ORDER BY autor.nome ASC";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    String textPaneText = textPane.getText();
                    string.append(textPaneText);

                    string.append("AUTHORS OF ONE THEME\n\n");
                    string.append("TITULO\tNOME\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        USERTHATLENTPUBLICATIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String[] aux = input.split(" ");
                    String query = "SELECT nome FROM Usuario WHERE cod_usuario = (SELECT cod_usuario FROM Emprestimo WHERE cod_publicacao = (SELECT cod_publicacao FROM Publicacao WHERE titulo =  '" + input + "'))";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    String textPaneText = textPane.getText();
                    string.append(textPaneText);

                    string.append("USER THAT LENT PUBLICATION\n\n");
                    string.append("USUARIO\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        ALPHABETARYPUBLICATIONSBYAUTHORButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String[] aux = input.split(" ");
                    String query = "SELECT titulo,nome from publicacao natural join criacao natural join autor order by nome asc";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    String textPaneText = textPane.getText();
                    string.append(textPaneText);

                    string.append("ALPHABETARY PUBLICATIONS BY AUTHOR\n\n");
                    string.append("TITULO\tNOME\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        ANNUALCONFERENCEARTICLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane.setText("");
                try {
                    String input = textField1.getText();
                    String[] aux = input.split(" ");
                    String query = "SELECT DISTINCT publicacao.titulo FROM `publicacao` INNER JOIN anal_conferencia WHERE publicacao.cod_publicacao = (SELECT cod_publicacao from anal_conferencia WHERE titulo = '" + input + "') AND publicacao.cod_tipoPublicacao = 1;";
                    connection.statement = connection.connection.createStatement();
                    ResultSet resultSet = connection.statement.executeQuery(query);
                    StringBuilder string = new StringBuilder();

                    String textPaneText = textPane.getText();
                    string.append(textPaneText);

                    string.append("ANNUAL CONFERENCE ARTICLE\n\n");
                    string.append("TITULO\n");

                    while (resultSet.next()) {
                        string.append(resultSet.getString(1) + "\n");
                    }
                    System.out.println(string);

                    textPane.setText(String.valueOf(string));

                    connection.statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException {
        createFrame();
        configureMainFrame();
        connection.connect();
    }

    private static void createFrame() {
        frame = new JFrame("main");
    }

    private static void configureMainFrame() {
        frame.setContentPane(new form().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
