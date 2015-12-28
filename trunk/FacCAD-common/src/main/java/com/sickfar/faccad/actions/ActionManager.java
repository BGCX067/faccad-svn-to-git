package com.sickfar.faccad.actions;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public final class ActionManager {

    private ActionManager() {
    }

    private static final Map<String, Action> actions = new HashMap<>();

    public static final Action EDIT_COPY = new DefaultEditorKit.CopyAction();
    public static final Action EDIT_CUT = new DefaultEditorKit.CutAction();
    public static final Action EDIT_PASTE = new DefaultEditorKit.PasteAction();

    static { //actions map initialisation.
        EDIT_COPY.putValue(Action.LARGE_ICON_KEY, new ImageIcon(ActionManager.class.getResource("/icons/32/documents.png")));
        EDIT_COPY.putValue(Action.SMALL_ICON, new ImageIcon(ActionManager.class.getResource("/icons/16/documents.png")));
        EDIT_COPY.putValue(Action.NAME, "Copy");
        EDIT_COPY.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        actions.put("EDIT_COPY", EDIT_COPY);

        EDIT_CUT.putValue(Action.LARGE_ICON_KEY, new ImageIcon(ActionManager.class.getResource("/icons/32/scissors.png")));
        EDIT_CUT.putValue(Action.SMALL_ICON, new ImageIcon(ActionManager.class.getResource("/icons/16/scissors.png")));
        EDIT_CUT.putValue(Action.NAME, "Cut");
        EDIT_CUT.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        actions.put("EDIT_CUT", EDIT_CUT);

        EDIT_PASTE.putValue(Action.LARGE_ICON_KEY, new ImageIcon(ActionManager.class.getResource("/icons/32/clipboard.png")));
        EDIT_PASTE.putValue(Action.SMALL_ICON, new ImageIcon(ActionManager.class.getResource("/icons/16/clipboard.png")));
        EDIT_PASTE.putValue(Action.NAME, "Paste");
        EDIT_PASTE.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        actions.put("EDIT_PASTE", EDIT_PASTE);
    }

    public static Action register(String key, Action action) {
        actions.put(key, action);
        return actions.get(key);
    }

    public static Action get(String key) {
        return actions.get(key);
    }

}
