package org.jhotdraw.samples.draw;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;

import java.awt.geom.Rectangle2D;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ThenFigurePosition {
    @ExpectedScenarioState
    private DrawingEditor editor;

    private List<Figure> figureList;

    ThenFigurePosition figureHasMoved(){
        figureList = editor.getActiveView().getDrawing().getFiguresFrontToBack();
        assert figureList.size() > 0;

        figureList.forEach((Figure figure) -> {
            Rectangle2D.Double bounds = figure.getBounds();
            assertBounds(bounds);
        });
        return this;
    }

    private void assertBounds(Rectangle2D.Double bounds) {
        assertTrue(bounds.x != 0);
        assertTrue(bounds.y != 0);
    }
}
