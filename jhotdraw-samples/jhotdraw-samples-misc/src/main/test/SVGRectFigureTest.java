import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.samples.svg.figures.LinkHandle;
import org.jhotdraw.samples.svg.figures.SVGRectRadiusHandle;
import org.junit.Before;
import org.junit.Test;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

import javax.swing.*;

public class SVGRectFigureTest {

    SVGRectFigure SVGRectFigure;

    @Before
    public void setUp(){
        SVGRectFigure = new SVGRectFigure();
    }

    @Test
    public void testCreateHandles_detailLevelMinus1() {
        int detailLevel = -1;
        Collection<Handle> handles = SVGRectFigure.createHandles(detailLevel);

        assertEquals(1, handles.size());
        System.out.println("Checking if handles list contains ");
    }

    @Test
    public void testCreateHandles_detailLevel0() {
        int detailLevel = 0;
        Collection<Handle> handles = SVGRectFigure.createHandles(detailLevel);

        assertTrue(handles.size() >= 3);
        assertTrue(handles.stream().anyMatch(handle -> handle instanceof SVGRectRadiusHandle));
    }

    @Test
    public void testCreateHandles_detailLevel1() {
        int detailLevel = 1;
        Collection<Handle> handles = SVGRectFigure.createHandles(detailLevel);

        // addTransformHandles() check
        assertTrue(handles.size() > 0);
    }

    @Test
    public void testDrawStroke() {

        Graphics2D g = mock(Graphics2D.class);

        // set roundrect object zero arc width and height
        RoundRectangle2D.Double roundrect = new RoundRectangle2D.Double();
        roundrect.arcwidth = 0;
        roundrect.archeight = 0;

        // call drawStroke method
        //drawStroke(g);

        //
        //verify(g).draw(roundrect.getBounds2D());
    }
}