package JGivenFontPalette;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class FontPaletteTest extends ScenarioTest<GivenTextFigure, WhenIPressButton, ThenTextChange> {

    @Test
    public void changeFontFace(){
        given().aTextFigure();
        when().IChangeFontFace();
        then().textFontFaceHasChanged();
    }

    @Test
    public void changeFontSize(){
        given().aTextFigure();
        when().IChangeFontSize();
        then().textFontSizeHasChanged();
    }

    @Test
    public void selectBoldText(){
        given().aTextFigure();
        when().boldFontButtonPressed();
        then().textHasChangedToBold();

    }

    @Test
    public void selectItalicText(){
        given().aTextFigure();
        when().italicFontButtonPressed();
        then().textHasChangedToItalic();
    }

    @Test
    public void underlineText(){
        given().aTextFigure();
        when().underlineFontButtonPressed();
        then().textHasChangedBeenUnderlined();
    }
}
