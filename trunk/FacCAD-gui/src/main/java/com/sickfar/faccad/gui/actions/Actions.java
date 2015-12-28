package com.sickfar.faccad.gui.actions;

import com.sickfar.faccad.actions.ActionManager;
import com.sickfar.faccad.gui.SettingsDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Actions {

    public static final Action CREATE_PROJECT;
    public static final Action OPEN_PROJECT;
    public static final Action SAVE_PROJECT;
    public static final Action PROGRAM_OPTIONS;

    static {
        CREATE_PROJECT = new AbstractAction("Create Project") {
            {
                putValue(Action.LARGE_ICON_KEY, new ImageIcon(Actions.class.getResource("/icons/32/document.png")));
                putValue(Action.SMALL_ICON, new ImageIcon(Actions.class.getResource("/icons/16/document.png")));
                putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
                putValue(Action.ACTION_COMMAND_KEY, "CREATE_PROJECT");
                putValue(Action.SHORT_DESCRIPTION, "Create project");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: implement
                System.out.println("Create new project");
            }
        };

        OPEN_PROJECT = new AbstractAction("Open Project") {
            {
                putValue(Action.LARGE_ICON_KEY, new ImageIcon(Actions.class.getResource("/icons/32/folder.png")));
                putValue(Action.SMALL_ICON, new ImageIcon(Actions.class.getResource("/icons/16/folder.png")));
                putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
                putValue(Action.ACTION_COMMAND_KEY, "OPEN_PROJECT");
                putValue(Action.SHORT_DESCRIPTION, "Open project");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: implement
                System.out.println("Open project");
            }
        };

        SAVE_PROJECT = new AbstractAction("Save Project") {
            {
                putValue(Action.LARGE_ICON_KEY, new ImageIcon(Actions.class.getResource("/icons/32/floppy-disk.png")));
                putValue(Action.SMALL_ICON, new ImageIcon(Actions.class.getResource("/icons/16/floppy-disk.png")));
                putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
                putValue(Action.ACTION_COMMAND_KEY, "SAVE_PROJECT");
                putValue(Action.SHORT_DESCRIPTION, "Save project");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: implement
                System.out.println("Save project");
            }
        };

        PROGRAM_OPTIONS = new AbstractAction("Settings") {
            {
                putValue(Action.LARGE_ICON_KEY, new ImageIcon(Actions.class.getResource("/icons/32/gears.png")));
                putValue(Action.SMALL_ICON, new ImageIcon(Actions.class.getResource("/icons/16/gears.png")));
                putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.SHIFT_MASK + InputEvent.CTRL_MASK));
                putValue(Action.ACTION_COMMAND_KEY, "PROGRAM_OPTIONS");
                putValue(Action.SHORT_DESCRIPTION, "Common program settings");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsDialog().setVisible(true);
            }
        };

        registerGUIActions();
    }

    public static void registerGUIActions() {
        ActionManager.register("CREATE_PROJECT", CREATE_PROJECT);
        ActionManager.register("OPEN_PROJECT", OPEN_PROJECT);
        ActionManager.register("SAVE_PROJECT", SAVE_PROJECT);
        ActionManager.register("PROGRAM_OPTIONS", PROGRAM_OPTIONS);
    }
}
