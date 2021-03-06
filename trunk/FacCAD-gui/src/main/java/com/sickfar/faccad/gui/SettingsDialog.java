package com.sickfar.faccad.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonClose;
    private JTabbedPane tabContainer;
    private JPanel commonTab;
    private JPanel modulesTab;

    public SettingsDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonClose);
        pack();
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });
        tabContainer.setIconAt(tabContainer.indexOfComponent(commonTab), new ImageIcon(getClass().getResource("/icons/32/gear.png")));
        tabContainer.setIconAt(tabContainer.indexOfComponent(modulesTab), new ImageIcon(getClass().getResource("/icons/32/puzzle.png")));
    }

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
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel1, BorderLayout.SOUTH);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel1.add(panel2, BorderLayout.CENTER);
        buttonClose = new JButton();
        buttonClose.setText("Close");
        panel2.add(buttonClose, BorderLayout.EAST);
        final JSeparator separator1 = new JSeparator();
        panel2.add(separator1, BorderLayout.CENTER);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel3, BorderLayout.CENTER);
        tabContainer = new JTabbedPane();
        tabContainer.setTabLayoutPolicy(0);
        tabContainer.setTabPlacement(2);
        panel3.add(tabContainer, BorderLayout.CENTER);
        commonTab = new JPanel();
        commonTab.setLayout(new BorderLayout(0, 0));
        tabContainer.addTab("Common", commonTab);
        modulesTab = new JPanel();
        modulesTab.setLayout(new BorderLayout(0, 0));
        tabContainer.addTab("Modules", modulesTab);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
