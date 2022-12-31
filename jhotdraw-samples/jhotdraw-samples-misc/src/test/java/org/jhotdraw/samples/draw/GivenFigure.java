package org.jhotdraw.samples.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.*;

public class GivenFigure extends Stage<GivenFigure> {
    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    GivenFigure rectangleFigure(){
        SVGRectFigure rect = new SVGRectFigure();
        editor.getActiveView().getDrawing().add(rect);

        return this;
    }

    GivenFigure ellipseFigure(){
        SVGEllipseFigure ellipse = new SVGEllipseFigure();
        editor.getActiveView().getDrawing().add(ellipse);

        return this;
    }

    GivenFigure imageFigure(){
        SVGImageFigure image = new SVGImageFigure();
        editor.getActiveView().getDrawing().add(image);

        return this;
    }

    GivenFigure textAreaFigure() {
        SVGTextAreaFigure textFigure = new SVGTextAreaFigure("The text figure");
        editor.getActiveView().getDrawing().add(textFigure);

        return this;
    }
}
