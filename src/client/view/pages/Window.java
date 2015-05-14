package client.view.pages;

import javax.swing.*;
import java.awt.*;

public abstract class Window {

    protected JPanel panel;

    protected Window() {
        panel = new JPanel();
        panel.setBackground(new Color(77, 79, 76));
        panel.setBounds(0, 0, 960, 640);
        panel.setVisible(true);
        panel.setLayout(null);
    }


    public JPanel getPanel() {
        return panel;
    }

}
