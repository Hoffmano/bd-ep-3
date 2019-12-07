import javax.swing.*;

public class form {
    private JButton CREATEButton;
    private JButton READButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form");
        frame.setContentPane(new Form().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
