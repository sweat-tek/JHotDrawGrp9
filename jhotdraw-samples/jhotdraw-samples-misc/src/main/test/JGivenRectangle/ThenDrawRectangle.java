package JGivenRectangle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import static org.junit.Assert.*;


public class ThenDrawRectangle extends Stage<ThenDrawRectangle> {

    @ExpectedScenarioState
    private DrawingView view;

    @ProvidedScenarioState
    private SVGRectFigure rectFigure;

    ThenDrawRectangle aRectangleIsDrawnOnTheCanvas() {
        assert(view.getDrawing().contains(rectFigure));
        return this;
    }
}
