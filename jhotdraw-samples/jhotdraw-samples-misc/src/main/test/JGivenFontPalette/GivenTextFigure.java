package JGivenFontPalette;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.BezierFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;


public class GivenTextFigure extends Stage<GivenTextFigure> {
    @ProvidedScenarioState
    private DrawingEditor editor;
    private SVGTextFigure textFigure;

    @BeforeStage
    public void before(){
        editor = new DefaultDrawingEditor();
        textFigure = new SVGTextFigure();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    GivenTextFigure aTextFigure(){
        editor.getActiveView().getDrawing().add(textFigure);
        editor.getActiveView().addToSelection(textFigure);
        return this;
    }

}
