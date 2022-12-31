package JGivenFontPalette;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static javax.swing.UIManager.get;
import static org.jhotdraw.draw.AttributeKeys.*;
import static org.junit.Assert.*;

public class ThenTextChange {
    @ExpectedScenarioState
    private DrawingEditor editor;
    @ExpectedScenarioState
    private Set<Figure> textFigures;


    ThenTextChange textFontFaceHasChanged(){
        assertEquals("Verdana", FONT_FACE.get(textFigures.iterator().next()).getName());
        return this;
    }
    ThenTextChange textFontSizeHasChanged(){
        Figure fontFigure = textFigures.iterator().next();
        int result = FONT_FACE.get(fontFigure).getSize();
        assertEquals(16,result);
        return this;
    }
    ThenTextChange textHasChangedToBold(){
        assertTrue(FONT_BOLD.get(textFigures.iterator().next()));
        return this;
    }
    ThenTextChange textHasChangedToItalic(){
        Figure fontFigure = textFigures.iterator().next();
        int result = FONT_FACE.get(fontFigure).getStyle();
        assertEquals(2, result);
        return this;
    }
    ThenTextChange textHasChangedBeenUnderlined(){
        Figure fontFigure = textFigures.iterator().next();
        assertTrue(FONT_UNDERLINE.get(fontFigure));
        return this;
    }
}
