package CUOM;

import sun.applet.Main;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class MainClass {
    static GameFrame MainFrame;
    public static String gameState = "Menu";
    static ArrayList<JComponent> grComps;
    // Settings
    public static int Width=800,Height=450,fsHeight, previous_drag_position_x;
    public static int previous_drag_position_y, cursor_x, cursor_y;
    public static boolean fullscreen,Lenin,LGBT, Init;
    public static byte music,sound;
    static ArrayList<World> Worlds; // Array of ZAWARDO (for самые тупые)
    public static void StateSwitcher() {
        if (grComps.size() != 0) removeAllComponents(MainFrame);
        MainFrame.setLayout(null);
        if (gameState.equals("Menu")) {
            // Single Player Button
            JButton singlePlayer = new JButton("Одиночная (как и ты) игра");
            singlePlayer.addKeyListener(new EventClass("",""));
            singlePlayer.setBounds(Width / 3, Height / 6, Width / 3, Height / 6);
            singlePlayer.addActionListener(new EventClass("EnterWorldSelect", "Menu"));
            // Multi Player Button
            JButton multiPlayer = new JButton("Многопользовательская (ТоЛьКо С тВоЕй РуКоЙ) игра");
            multiPlayer.setBounds(Width / 3, Height / 3 + Height / 80, Width / 3, Height / 6);
            // Settings Button Lol
            JButton settingsButton = new JButton("Настройки(ТеБя ОнИ нЕ иСпРаВяТ)");
            settingsButton.setBounds(Width / 3, Height / 2 + Height / 40, Width / 3, Height / 6);
            settingsButton.addActionListener(new EventClass("EnterSettings", "Menu"));
            // Actually Exit Button
            JButton exitButton = new JButton("вiйти (иди нахуй)");
            exitButton.setBounds(Width / 3, Height * 2 / 3 + Height * 3 / 80, Width / 3, Height / 6);
            exitButton.addActionListener(new EventClass("Exit", "Menu"));
            // Adding Elements
            MainFrame.add(singlePlayer);
            MainFrame.add(multiPlayer);
            MainFrame.add(settingsButton);
            MainFrame.add(exitButton);
            grComps.add(singlePlayer);
            grComps.add(multiPlayer);
            grComps.add(settingsButton);
            grComps.add(exitButton);
        } else if (gameState.equals("Settings")) {
            // Music Slider
            JSlider musicSlider = new JSlider(SwingConstants.HORIZONTAL);
            musicSlider.setBounds(Width / 15, 0, Width * 2 / 5, Height / 12);
            musicSlider.setValue(music);
            musicSlider.setMajorTickSpacing(10);
            musicSlider.setMinorTickSpacing(5);
            musicSlider.setPaintTicks(true);
            // Sound Slider
            JSlider soundSlider = new JSlider(SwingConstants.HORIZONTAL);
            soundSlider.setBounds(Width / 15, Height / 12, Width * 2 / 5, Height / 12);
            soundSlider.setValue(sound);
            soundSlider.setMajorTickSpacing(10);
            soundSlider.setMinorTickSpacing(5);
            soundSlider.setPaintTicks(true);
            // FullScreen Checkbox
            JCheckBox fullScreen = new JCheckBox("Fullscrыn");
            fullScreen.setBounds(Width / 15, Height / 6, Width / 10, Height / 12);
            // Screen Resolution List TODO
            JList screenResolution = new JList();
            screenResolution.setBounds(Width / 15 + Width * 2 / 5 - Width / 10, Height / 6 + Height / 60, Width / 10, Height / 20);
            // Lenin Button TODO
            JButton LeninButton = new JButton("Lenin Button");
            LeninButton.setBounds(Width / 15 + Width * 2 / 5 + Width / 20, 0, Width * 2 / 5, Height / 12);
            // LGBT Button TODO
            JButton LGBTButton = new JButton("LGBT Button");
            LGBTButton.setBounds(Width / 15 + Width * 2 / 5 + Width / 20, Height / 12, Width * 2 / 5, Height / 12);
            // Option Exit Button
            JButton optionExit = new JButton("Exit and DespaSave");
            optionExit.setBounds(Width / 7, Height * 5 / 6, Width * 5 / 7, Height / 12);
            optionExit.addActionListener(new EventClass("Exit", "Settings"));
            // Adding Elements
            MainFrame.add(musicSlider);
            MainFrame.add(soundSlider);
            MainFrame.add(fullScreen);
            MainFrame.add(screenResolution);
            MainFrame.add(LeninButton);
            MainFrame.add(LGBTButton);
            MainFrame.add(optionExit);
            grComps.add(musicSlider);
            grComps.add(soundSlider);
            grComps.add(fullScreen);
            grComps.add(screenResolution);
            grComps.add(LeninButton);
            grComps.add(LGBTButton);
            grComps.add(optionExit);
        } else if (gameState.equals("WorldSelect")) {
            DefaultListModel fuckthisshit = new DefaultListModel();
            //World select list
            fuckthisshit.addElement("121212");
            JList WorldList = new JList(fuckthisshit);
            JScrollPane ZAWARUDOList = new JScrollPane(WorldList);
            ZAWARUDOList.setBounds(Width / 30, Height / 30, Width / 3, Height * 13 / 15);
            //кнопка загрузки мира
            JButton loadWorld = new JButton("Load");
            loadWorld.setBounds(Width / 3 + Width / 20, Height * 4 / 5, Width * 5 / 36, Height / 10);
            //кнопка создания мира
            JButton createWorld = new JButton("Create");
            createWorld.setBounds(Width / 3 + Width / 20 + Width * 11 / 72, Height * 4 / 5, Width * 5 / 36, Height / 10);
            createWorld.addActionListener(new EventClass("EnterWorldCreate", "WorldSelect"));
            //Delete World Button
            JButton deleteButton = new JButton("Delete");
            deleteButton.setBounds(Width / 3 + Width / 20 + Width * 11 / 36, Height * 4 / 5, Width * 5 / 36, Height / 10);
            //Exit Options Button
            JButton exitOptions = new JButton("Exit");
            exitOptions.setBounds(Width / 3 + Width / 20 + Width * 11 / 24, Height * 4 / 5, Width * 5 / 36, Height / 10);
            exitOptions.addActionListener(new EventClass("Exit", "WorldSelect"));
            //Information about worlds
            JLabel worldInformation = new JLabel("ЫЫЫЫ" + "\n" + "ЫЫЫЫЫЫЫЫЫ" + "\n" + "ЫЫЫЫЫЫЫЫЫЫ");
            worldInformation.setVerticalAlignment(SwingConstants.TOP);
            worldInformation.setHorizontalTextPosition(SwingConstants.LEFT);
            worldInformation.setText("ЫЫЫЫ" + "\n" + "ЫЫЫЫЫЫЫЫЫ" + "\n" + "ЫЫЫЫЫЫЫЫЫЫ");
            worldInformation.setBounds(Width / 3 + Width / 20 + Width / 72, Height / 30, Width * 7 / 12, Height * 23 / 30);
            //Adding Elements
            MainFrame.add(ZAWARUDOList);
            MainFrame.add(loadWorld);
            MainFrame.add(createWorld);
            MainFrame.add(deleteButton);
            MainFrame.add(exitOptions);
            MainFrame.add(worldInformation);
            //Adding Components to grComps
            grComps.add(WorldList);
            grComps.add(ZAWARUDOList);
            grComps.add(loadWorld);
            grComps.add(createWorld);
            grComps.add(deleteButton);
            grComps.add(exitOptions);
            grComps.add(worldInformation);
        } else if (gameState.equals("WorldCreate")) {
            MaskFormatter sizeLimits = new MaskFormatter();
            try {
                sizeLimits.setMask("###");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //Текстовое поле ввода имени мира; айди компонента: 0
            JTextField WorldName = new JTextField();
            WorldName.setHorizontalAlignment(SwingConstants.CENTER);
            WorldName.setBounds(Width / 3, Height / 40, Width / 3, Height / 20);
            //Текстовое поле ввода высоты мира; айди компонента: 1
            JFormattedTextField WorldHeight = new JFormattedTextField(sizeLimits);
            WorldHeight.setHorizontalAlignment(SwingConstants.RIGHT);
            WorldHeight.setBounds(Width * 2 / 7, Height / 10, Width / 10, Height / 20);
            //Текстовое поле ввода ширины мира; айди компонента: 2
            JFormattedTextField WorldWidth = new JFormattedTextField(sizeLimits);
            WorldWidth.setHorizontalAlignment(SwingConstants.RIGHT);
            WorldWidth.setBounds(Width * 2 / 7, Height * 3 / 20, Width / 10, Height / 20);
            //Кнопка создания мира; айди компонента: 3
            JButton WorldCreateButton = new JButton("Создать");
            WorldCreateButton.setBounds(Width * 5 / 7 - Width / 50, Height * 12 / 15, Width * 2 / 15, Height / 10 + Height / 60);
            WorldCreateButton.addActionListener(new EventClass("CreateWorld", "WorldCreate"));
            //Кнопка Выхода из создания мира; айди компонента: 4
            JButton WorldCreateExitButton = new JButton("Вiйти");
            WorldCreateExitButton.addActionListener(new EventClass("Exit", "WorldCreate"));
            WorldCreateExitButton.setBounds(Width * 5 / 7 + Width * 2 / 15 - Width * 2 / 50 + Width / 35, Height * 12 / 15, Width * 2 / 15, Height / 10 + Height / 60);
            //добавление компонентов на Фрейм
            removeAllComponents(MainFrame);
            MainFrame.add(WorldName);
            MainFrame.add(WorldHeight);
            MainFrame.add(WorldWidth);
            MainFrame.add(WorldCreateButton);
            MainFrame.add(WorldCreateExitButton);
            //добавление компонентов в grComps
            grComps.add(WorldName);
            grComps.add(WorldHeight);
            grComps.add(WorldWidth);
            grComps.add(WorldCreateButton);
            grComps.add(WorldCreateExitButton);
        } else if (gameState.equals("WorldCreating")) {
            //Главная панель игры; айди компонента: 0
            JPanel MainGamePanel = new JPanel(null);
            MainGamePanel.setBounds(Width /8, Height /15, Width * 7 / 8, Height * 12 / 15);
            MainGamePanel.setBackground(Color.red);
            MainGamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            //добавление компонентов на фрейм
            MainFrame.add(MainGamePanel);
            // добавление компоненты в grComps
            grComps.add(MainGamePanel);
        }
        MainFrame.repaint();
    }
    public static void removeAllComponents(JFrame frame) {           // убирает все компоненты с игрового окошка
        for(int i = 0; i < grComps.size(); i++)
            frame.remove(grComps.get(i));
        grComps.clear();
    }
    public static void main(String[]args){
        grComps = new ArrayList<JComponent>();
        Worlds = new ArrayList<World>();
        MainFrame = new GameFrame();
        MainFrame.addMouseListener(new EventClass(" "," "));
        MainFrame.addMouseMotionListener(new EventClass("",""));
        MainFrame.setSize(Width,Height);
        MainFrame.setResizable(false);
        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        StateSwitcher();
    }
}