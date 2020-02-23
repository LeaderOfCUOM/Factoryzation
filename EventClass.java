package CUOM;

import javafx.application.Application;
import sun.applet.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.lang.management.GarbageCollectorMXBean;
import java.util.Scanner;

public class EventClass implements ActionListener, ListSelectionListener, MouseMotionListener, KeyListener, MouseListener {
    /*Группы:
    Menu - меню самой игры
    WorldSelect - выбор мира
    Settings - настройки
    WorldCreate - окно создания мира

    */
    public EventClass(String actionType, String action_Group) { action_type = actionType;action_group = action_Group;
    }
    String action_type;
    String action_group;
    @Override
    public void actionPerformed(ActionEvent e) {
        // Buttons
        if (action_group.equals("Menu")) {

            if (action_type.equals("EnterSettings")) {
                MainClass.gameState = "Settings";
                MainClass.StateSwitcher();
            } else if (action_type.equals("EnterWorldSelect")) {
                MainClass.gameState = "WorldSelect";
                MainClass.StateSwitcher();
            } else if (action_type.equals("Exit")) {
                System.exit(0);
            }
        }
        else if (action_group.equals("WorldSelect")) {
                if (action_type.equals("EnterWorldCreate")) {
                    MainClass.gameState = "WorldCreate";
                    MainClass.StateSwitcher();
                } else if (action_type.equals("Exit")) {
                    MainClass.gameState = "Menu";
                    MainClass.StateSwitcher();
                }
            }
        else if(action_group.equals("Settings")) {
            if (action_type.equals("Exit")) {
                MainClass.gameState = "Menu";
                MainClass.StateSwitcher();
            }
        }
        else if(action_group.equals("WorldCreate"))
        {
            if(action_type.equals("Exit"))
            {
                MainClass.gameState = "WorldSelect";
                MainClass.StateSwitcher();
            }
            else if (action_type.equals("CreateWorld"))
            {
                if (MainClass.Worlds.size() == 0)
                {
                    MainClass.Worlds.add(new World());
                }
                else
                {
                    for (int i = 0; i < MainClass.Worlds.size() - 1; i++) {
                        MainClass.Worlds.remove(1);
                    }
                }
                MainClass.Worlds.get(0).create_world();
                MainClass.gameState = "WorldCreating";
                MainClass.StateSwitcher();
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (action_type.equals("WorldSelect")) {

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        MainClass.cursor_x = e.getX();
        MainClass.cursor_y = e.getY();
        System.out.println(MainClass.cursor_x + "при движении мышки");
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e
         */
        @Override
        public void mousePressed(MouseEvent e) {

        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            MainClass.previous_drag_position_x = e.getX();
            MainClass.previous_drag_position_y = e.getY();
            System.out.println(e.getX() + "при нажатии");
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e
         */
        @Override
        public void mouseExited(MouseEvent e) {

        }

}