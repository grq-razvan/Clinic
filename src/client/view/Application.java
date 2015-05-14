package client.view;

import javax.swing.SwingUtilities;

import client.view.pages.LoginPage;

public class Application {

    public static void show() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                new Frame();
                Frame.getFrame().add(new LoginPage().getPanel());
            }
        });
    }

}
