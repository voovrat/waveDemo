import javax.swing.*;

/**
 * Created by volodymyr.sergiievsk on 11.10.2016.
 */
public class PaneFrame extends JFrame {

    public PaneFrame(Pane pane) {
        setResizable(true);
        setVisible(true);
        setBounds(0,0,pane.w(),pane.h());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); repaint();
        add(pane);

    }
}
