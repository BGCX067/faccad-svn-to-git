package com.sickfar.faccad.gui;

import com.sickfar.faccad.actions.ActionManager;
import com.sickfar.faccad.gui.actions.Actions;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class MainWindow {

    //TODO: remove main method
    public static void main(String[] args) {
        new MainWindow().setVisible(true);
    }

    private JMenuBar menuBar = new JMenuBar();

    private void createMenus() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(Actions.CREATE_PROJECT);
        fileMenu.add(Actions.OPEN_PROJECT);
        fileMenu.add(Actions.SAVE_PROJECT);
        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(ActionManager.EDIT_CUT);
        editMenu.add(ActionManager.EDIT_COPY);
        editMenu.add(ActionManager.EDIT_PASTE);
        menuBar.add(editMenu);

        JMenu serviceMenu = new JMenu("Service");
        serviceMenu.add(Actions.PROGRAM_OPTIONS);
        menuBar.add(serviceMenu);
    }

    private void createToolbar() {
        mainToolbar.add(Actions.CREATE_PROJECT);
        mainToolbar.add(Actions.OPEN_PROJECT);
        mainToolbar.add(Actions.SAVE_PROJECT);
        mainToolbar.add(new JToolBar.Separator());
        mainToolbar.add(Actions.PROGRAM_OPTIONS);
    }

    private JFrame mainFrame = new JFrame();

    public MainWindow() {
        createMenus();
        createToolbar();
        mainFrame.setJMenuBar(menuBar);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(800, 600));
        mainFrame.add(mainPanel);
        mainFrame.setTitle("FacCAD");
        mainFrame.pack();
    }

    public void setVisible(boolean visible) {
        mainFrame.setVisible(visible);
    }

    private JPanel mainPanel;
    private JTabbedPane mainWizardPane;
    private JList openedProjectList;
    private JButton enableProjectButton;
    private JButton closeProjectButton;
    private JProgressBar statusProgressBar;
    private JPanel projectControlPanel;
    private JPanel buttonsPanel;
    private JToolBar mainToolbar;
    private JPanel statusPanel;
    private JLabel statusLabel;
    private JSplitPane mainSplitPane;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainSplitPane = new JSplitPane();
        mainSplitPane.setOneTouchExpandable(false);
        mainPanel.add(mainSplitPane, BorderLayout.CENTER);
        mainSplitPane.setBorder(BorderFactory.createTitledBorder(""));
        projectControlPanel = new JPanel();
        projectControlPanel.setLayout(new BorderLayout(0, 0));
        mainSplitPane.setLeftComponent(projectControlPanel);
        final JLabel label1 = new JLabel();
        label1.setText("Opened projects");
        projectControlPanel.add(label1, BorderLayout.NORTH);
        openedProjectList = new JList();
        projectControlPanel.add(openedProjectList, BorderLayout.CENTER);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout(0, 0));
        projectControlPanel.add(buttonsPanel, BorderLayout.SOUTH);
        closeProjectButton = new JButton();
        closeProjectButton.setIcon(new ImageIcon(getClass().getResource("/icons/16/button-cross.png")));
        closeProjectButton.setText("");
        closeProjectButton.setToolTipText("Close Selected Project");
        buttonsPanel.add(closeProjectButton, BorderLayout.EAST);
        enableProjectButton = new JButton();
        enableProjectButton.setIcon(new ImageIcon(getClass().getResource("/icons/16/button-check.png")));
        enableProjectButton.setText("");
        enableProjectButton.setToolTipText("Enable Selected Project");
        buttonsPanel.add(enableProjectButton, BorderLayout.WEST);
        final JSeparator separator1 = new JSeparator();
        buttonsPanel.add(separator1, BorderLayout.CENTER);
        mainWizardPane = new JTabbedPane();
        mainSplitPane.setRightComponent(mainWizardPane);
        mainToolbar = new JToolBar();
        mainPanel.add(mainToolbar, BorderLayout.NORTH);
        statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.add(statusPanel, BorderLayout.SOUTH);
        statusProgressBar = new JProgressBar();
        statusProgressBar.setIndeterminate(true);
        statusProgressBar.setValue(0);
        statusPanel.add(statusProgressBar, BorderLayout.EAST);
        statusLabel = new JLabel();
        statusLabel.setText("Label");
        statusPanel.add(statusLabel, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
