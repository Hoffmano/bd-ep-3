import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createPublication {
    public JPanel panel;
    private JButton BACKButton;
    private JButton BOOKButton;
    private JButton BOOKSARTICLEButton;
    private JButton JOURNALPERIODICButton;
    private JButton CONFERENCEANNUALSButton;
    private JButton JOURNALARTICLEButton;
    private JButton MONOGRAPHSButton;
    private JButton CONFERENCEANNUALARTICLEButton;

    public createPublication() {
        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                form.frame.setContentPane(new form().panel);
                form.frame.setVisible(true);
            }
        });
    }
}
