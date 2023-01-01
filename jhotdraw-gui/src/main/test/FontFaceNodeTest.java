import org.jhotdraw.gui.fontchooser.FontsDictionary;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jhotdraw.gui.fontchooser.FontFaceNode;
import org.mockito.Mock;

import java.awt.*;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class FontFaceNodeTest {
    FontFaceNode service;

    @Before
    public void setUp(){
        service = new FontFaceNode();
    }

    @Test
    public void beautifyNameTest(){
        String result = service.beautifyName("AgencyFB-Bold");
        String expected = "Bold";
        assertEquals(expected, result);
    }

    @Test
    public void addSpacesToStringTest(){
        String result = service.addSpacesToString("BoldMT");
        String expected = "Bold MT";
        assertEquals(expected, result);
    }
}
