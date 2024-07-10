package View;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton CreateVMButton;
    private JButton TestVMButton;
    private JButton ExitButton;
    private JPanel MenuFrame;



    public MainMenu()
    {
        setContentPane(MenuFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

    }

    /*
    private void initcomponents(CreateMachine CM, TestMenu TM)
    {

        CreateVMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CM.setVisible(true);
                setVisible(false);
            }
        });

        TestVMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TM.setVisible(true);
                setVisible(false);
            }
        });
    }

     */

    public JButton getCreateVMButton() {
        return CreateVMButton;
    }

    public JButton getTestVMButton() {
        return TestVMButton;
    }

    public JButton getExitButton() {
        return ExitButton;
    }

    public JPanel getMenuFrame() {
        return MenuFrame;
    }


}
