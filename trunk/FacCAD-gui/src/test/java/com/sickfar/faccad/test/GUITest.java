package com.sickfar.faccad.test;

import com.sickfar.faccad.gui.MainWindow;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class GUITest {

    @Test
    public void test() {
        new MainWindow().setVisible(true);
    }

}
