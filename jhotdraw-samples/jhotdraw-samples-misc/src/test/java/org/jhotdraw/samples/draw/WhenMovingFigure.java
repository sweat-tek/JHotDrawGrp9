package org.jhotdraw.samples.draw;

import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;

import java.awt.geom.AffineTransform;
import java.util.Set;

public class WhenMovingFigure {
    @ProvidedScenarioState
    @ExpectedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    public void before() {
        editor.getActiveView().getDrawing().getFiguresFrontToBack().iterator().forEachRemaining(
                fig -> {
                    editor.getActiveView().addToSelection(fig);
                }
        );
    }

    WhenMovingFigure movingFigure(){
        assert editor.getActiveView().getSelectionCount() > 0;
        Set<Figure> figs = editor.getActiveView().getSelectedFigures();
        figs.forEach((Figure figure) -> {
            assert figure != null;
            AffineTransform transform = new AffineTransform();
            transform.translate(10, 10);
            figure.transform(transform);
            System.out.println(figure.getBounds() + " " + figure.getClass());
        });

        return this;
    }
}
