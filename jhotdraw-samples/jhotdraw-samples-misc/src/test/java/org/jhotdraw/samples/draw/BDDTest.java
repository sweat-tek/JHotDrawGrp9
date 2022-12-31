package org.jhotdraw.samples.draw;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class BDDTest extends ScenarioTest<GivenFigure, WhenMovingFigure, ThenFigurePosition> {
    @Test
    public void movingRectangleOnCanvas() {
        given().rectangleFigure();
        when().movingFigure();
        then().figureHasMoved();
    }

    @Test
    public void movingAllFiguresOnCanvas() {
        given()
                .rectangleFigure().and()
                .ellipseFigure().and()
                .imageFigure().and()
                .textAreaFigure();
        when().movingFigure();
        then().figureHasMoved();
    }
}
