import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form {
    private JButton CREATEButton;
    private JButton READButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JPanel panel;
    private static JFrame frame;

    public form() {
        actionListener(CREATEButton, "button create clicked");

        actionListener(READButton, "button read clicked");

        actionListener(UPDATEButton, "button update clicked");

        actionListener(DELETEButton, "button delete clicked");
    }

    private void actionListener(JButton createButton, String s) {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(s);
            }
        });
    }

    public static void main(String[] args) {
        createFrame();
        configureFrame();
    }

    private static void createFrame() {
        frame = new JFrame("Form");
    }

    private static void configureFrame() {
        frame.setContentPane(new form().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
