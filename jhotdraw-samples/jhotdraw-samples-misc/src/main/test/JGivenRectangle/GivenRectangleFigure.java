package JGivenRectangle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;


public class GivenRectangleFigure extends Stage<GivenRectangleFigure> {

    @ProvidedScenarioState
    private DrawingEditor editor;
    private SVGRectFigure rectFigure;

    @BeforeStage
    public void before(){
        editor = new DefaultDrawingEditor();
        rectFigure = new SVGRectFigure();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    GivenRectangleFigure aRectFigure(){
        editor.getActiveView().getDrawing().add(rectFigure);
        editor.getActiveView().addToSelection(rectFigure);
        return this;
    }

}
