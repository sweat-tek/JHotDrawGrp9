package JGivenRectangle;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;


import java.awt.geom.Point2D;

public class WhenIUseRectangleTool extends Stage<WhenIUseRectangleTool> {

    @ProvidedScenarioState
    private CreationTool creationTool;

    @ProvidedScenarioState
    private DrawingEditor editor;

    public WhenIUseRectangleTool theRectangleToolIsSelected() {
        creationTool = new CreationTool(new SVGRectFigure());
        return this;
    }

    public WhenIUseRectangleTool theUserClicksAndDragsOnTheCanvas() {
        creationTool.mousePressed(null);
        creationTool.mouseDragged(null);
        return this;
    }

    public WhenIUseRectangleTool theUserEditsARectangle() {
        // rec already seklected
        DrawingView view = editor.getActiveView();
        Figure selectedFigure = view.getSelectedFigures().iterator().next();
        if (selectedFigure instanceof SVGRectFigure) {
            SVGRectFigure rectFigure = (SVGRectFigure) selectedFigure;
            rectFigure.setBounds(new Point2D.Double(10, 10), new Point2D.Double(100, 100));
            // problem with getFigure
            //view.getDrawing().(rectFigure);
        }
        return this;
    }
}