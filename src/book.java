import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class book {
    private JTextField asdTextField;
    private JTextField TITLETextField;
    public JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton BACKButton;
    private JButton CREATEButton;

    public book() {
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.frame.setContentPane(new createPublication().panel);
                form.frame.setVisible(true);
            }
        });
    }
}
