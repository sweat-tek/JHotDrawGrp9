import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.fontchooser.*;
import org.jhotdraw.samples.svg.gui.FontToolBar;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;


public class FontToolBarTest{

    FontToolBar fontToolBar;
    JComponent jComponent;


    @Before
    public void setUp(){
        fontToolBar = new FontToolBar();
    }

    @Test
    public void createDisclosedComponentTest(){
        jComponent = fontToolBar.createDisclosedComponent(0);
        assertEquals(JPanel.class, jComponent.getClass());
    }





}

