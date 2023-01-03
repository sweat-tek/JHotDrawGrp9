package JGivenRectangle;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class RectangleTest extends ScenarioTest<GivenRectangleFigure, WhenIUseRectangleTool, ThenDrawRectangle> {

    @Test
    public void selectRectangleTool(){
        given().aRectFigure();
        when().theRectangleToolIsSelected();
        then().aRectangleIsDrawnOnTheCanvas();
    }

    @Test
    public void drawRectangleFigure(){
        given().aRectFigure();
        when().theUserClicksAndDragsOnTheCanvas();
        then().aRectangleIsDrawnOnTheCanvas();
    }

    @Test
    public void editRectangleFigure(){
        given().aRectFigure();
        when().theUserEditsARectangle();
        then().aRectangleIsDrawnOnTheCanvas();
    }

}
