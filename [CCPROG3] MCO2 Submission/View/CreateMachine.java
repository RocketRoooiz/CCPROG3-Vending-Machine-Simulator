package View;

import javax.swing.*;

public class CreateMachine extends JFrame{
    private JButton CreateVMButton;
    private JButton CreateSVMButton;
    private JLabel TitleLabel;
    private JPanel CreateFrame;

    public CreateMachine()
    {
        setContentPane(CreateFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public JButton getCreateVMButton() {
        return CreateVMButton;
    }

    public JButton getCreateSVMButton() {
        return CreateSVMButton;
    }

    public JLabel getTitleLabel() {
        return TitleLabel;
    }

    public JPanel getCreateFrame() {
        return CreateFrame;
    }
}
