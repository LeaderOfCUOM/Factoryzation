package CUOM;

import javax.swing.*;

/**
 * Created by user on 26.10.2019.
 */
public class GameFrame extends JFrame {
    @Override
    public void repaint() {
        if(!MainClass.gameState.equals("WorldCreating")) {
            super.repaint();
        }
        else
        {
            JPanel GamePane = (JPanel)MainClass.grComps.get(0);

        }
    }
}
